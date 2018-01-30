export enum BackendType {
    IN_MEMORY,
    REST,
    GRAPHQL,
}

export class BackendConfig {
    environmentType: BackendType;
    restServiceRoot: string;
}
