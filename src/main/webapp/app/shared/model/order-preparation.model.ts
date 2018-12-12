import { Moment } from 'moment';
import { IState } from 'app/shared/model//state.model';

export interface IOrderPreparation {
    id?: number;
    quantity?: number;
    dateOrder?: Moment;
    dateDelivery?: Moment;
    specialInstruction?: string;
    personId?: number;
    states?: IState[];
    dishId?: number;
}

export class OrderPreparation implements IOrderPreparation {
    constructor(
        public id?: number,
        public quantity?: number,
        public dateOrder?: Moment,
        public dateDelivery?: Moment,
        public specialInstruction?: string,
        public personId?: number,
        public states?: IState[],
        public dishId?: number
    ) {}
}
