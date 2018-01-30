import { AccessCode, Queue } from '../../shared/models/interfaces';

export interface UserResponse {
    id: number;
    modificationCounter: number;
    revision: any;
    token: string;
    email: string;
    name: string;
    phone: string;
}

export interface AccessCodeResponse {
    accessCode: AccessCode;
    queue: Queue;
}

export interface TermsResponse {
    id: number;
    modificationCounter: number;
    revision: any;
    description: string;
}

// Filters
export interface ExistingAccessCodeFilter {
    queueId: number;
    identificator: string;
    email?: string;
    phone?: string;
}

export interface UserFilter {
  name: string;
  email: string;
  phone: number;
  consent: boolean;
  url: string;
  queueId: number;
}
