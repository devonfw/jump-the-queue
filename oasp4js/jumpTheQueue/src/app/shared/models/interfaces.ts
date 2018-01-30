export interface AccessCode {
    id: number;
    name: string;
    phone: string;
    email: string;
    code: number;
    priority: boolean;
    creationTime: string;
    startTime: string;
    endTime: string;
    estimatedTime: string;
}

export interface Queue {
    id: number;
    descriptionText: string;
    logo: string;
}
