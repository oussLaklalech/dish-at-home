import { Moment } from 'moment';
import { IOrderPreparation } from 'app/shared/model//order-preparation.model';
import { IComment } from 'app/shared/model//comment.model';

export interface IPerson {
    id?: number;
    firstName?: string;
    lastName?: string;
    email?: string;
    phoneNumber?: string;
    birthday?: Moment;
    address?: string;
    cookerId?: number;
    orders?: IOrderPreparation[];
    comments?: IComment[];
}

export class Person implements IPerson {
    constructor(
        public id?: number,
        public firstName?: string,
        public lastName?: string,
        public email?: string,
        public phoneNumber?: string,
        public birthday?: Moment,
        public address?: string,
        public cookerId?: number,
        public orders?: IOrderPreparation[],
        public comments?: IComment[]
    ) {}
}
