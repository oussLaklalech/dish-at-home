export interface IComment {
    id?: number;
    content?: string;
    note?: number;
    personId?: number;
    dishId?: number;
}

export class Comment implements IComment {
    constructor(public id?: number, public content?: string, public note?: number, public personId?: number, public dishId?: number) {}
}
