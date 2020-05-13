export class FilterVisitor {
    pageable: Pageable;
    username: string;
    password?: string;
}
export class FilterAccessCode {
    pageable: Pageable;
    visitorId: Number;
}

export class FilterQueue {
    pageable: Pageable;
    active: boolean;
}
export class Pageable {
    pageSize: number;
    pageNumber: number;
    sort?: Sort[];
}

export class Sort {
    property: string;
    direction: string;
}

export class Visitor {
    id?: number;
    username: string;
    name: string;
    password: string;
    phoneNumber: string;
    acceptedCommercial: boolean;
    acceptedTerms: boolean;
    userType: boolean;
}

export class AccessCode {
    id?: number;
    ticketNumber: string;
    creationTime: string;
    startTime?: string;
    endTime?: string;
    visitorId: number;
    queueId: number;
}

export class Queue {
    id?: number;
    name: string;
    logo: string;
    currentNumber: string;
    attentionTime: string;
    minAttentionTime: string;
    active: boolean;
    customers: number;
}

export class Role {
    name: string;
    permission: number;
}
