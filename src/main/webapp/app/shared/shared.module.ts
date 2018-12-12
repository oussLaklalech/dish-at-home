import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';

import { NgbDateMomentAdapter } from './util/datepicker-adapter';
import { DishAtHomeSharedLibsModule, DishAtHomeSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
    imports: [DishAtHomeSharedLibsModule, DishAtHomeSharedCommonModule],
    declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
    entryComponents: [JhiLoginModalComponent],
    exports: [DishAtHomeSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DishAtHomeSharedModule {
    static forRoot() {
        return {
            ngModule: DishAtHomeSharedModule
        };
    }
}
