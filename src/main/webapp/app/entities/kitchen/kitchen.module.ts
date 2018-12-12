import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DishAtHomeSharedModule } from 'app/shared';
import {
    KitchenComponent,
    KitchenDetailComponent,
    KitchenUpdateComponent,
    KitchenDeletePopupComponent,
    KitchenDeleteDialogComponent,
    kitchenRoute,
    kitchenPopupRoute
} from './';

const ENTITY_STATES = [...kitchenRoute, ...kitchenPopupRoute];

@NgModule({
    imports: [DishAtHomeSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        KitchenComponent,
        KitchenDetailComponent,
        KitchenUpdateComponent,
        KitchenDeleteDialogComponent,
        KitchenDeletePopupComponent
    ],
    entryComponents: [KitchenComponent, KitchenUpdateComponent, KitchenDeleteDialogComponent, KitchenDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DishAtHomeKitchenModule {}
