import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { IPerson } from 'app/shared/model/person.model';
import { PersonService } from './person.service';
import { IKitchen } from 'app/shared/model/kitchen.model';
import { KitchenService } from 'app/entities/kitchen';

@Component({
    selector: 'jhi-person-update',
    templateUrl: './person-update.component.html'
})
export class PersonUpdateComponent implements OnInit {
    person: IPerson;
    isSaving: boolean;

    cookers: IKitchen[];
    birthday: string;

    constructor(
        private jhiAlertService: JhiAlertService,
        private personService: PersonService,
        private kitchenService: KitchenService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ person }) => {
            this.person = person;
            this.birthday = this.person.birthday != null ? this.person.birthday.format(DATE_TIME_FORMAT) : null;
        });
        this.kitchenService.query({ filter: 'person-is-null' }).subscribe(
            (res: HttpResponse<IKitchen[]>) => {
                if (!this.person.cookerId) {
                    this.cookers = res.body;
                } else {
                    this.kitchenService.find(this.person.cookerId).subscribe(
                        (subRes: HttpResponse<IKitchen>) => {
                            this.cookers = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.person.birthday = this.birthday != null ? moment(this.birthday, DATE_TIME_FORMAT) : null;
        if (this.person.id !== undefined) {
            this.subscribeToSaveResponse(this.personService.update(this.person));
        } else {
            this.subscribeToSaveResponse(this.personService.create(this.person));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IPerson>>) {
        result.subscribe((res: HttpResponse<IPerson>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackKitchenById(index: number, item: IKitchen) {
        return item.id;
    }
}
