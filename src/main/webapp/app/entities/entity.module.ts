import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { DishAtHomePersonModule } from './person/person.module';
import { DishAtHomeKitchenModule } from './kitchen/kitchen.module';
import { DishAtHomeOrderPreparationModule } from './order-preparation/order-preparation.module';
import { DishAtHomeStateModule } from './state/state.module';
import { DishAtHomeDishModule } from './dish/dish.module';
import { DishAtHomeCommentModule } from './comment/comment.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        DishAtHomePersonModule,
        DishAtHomeKitchenModule,
        DishAtHomeOrderPreparationModule,
        DishAtHomeStateModule,
        DishAtHomeDishModule,
        DishAtHomeCommentModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DishAtHomeEntityModule {}
