import { NgModule } from '@angular/core';

import { DishAtHomeSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [DishAtHomeSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [DishAtHomeSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class DishAtHomeSharedCommonModule {}
