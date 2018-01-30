// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
import { BackendType } from '../app/config';

export const environment: {
  production: boolean,
  backendType: BackendType,
  domain: string,
  restPathRoot: string,
  restServiceRoot: string,
  queueId: number
} = {
  production: false,
  backendType: BackendType.REST,
  domain: 'http://localhost:4200/confirmation/',
  restPathRoot: 'http://localhost:8081/JumpTheQueue/',
  restServiceRoot: 'http://localhost:8081/JumpTheQueue/services/rest/',
  queueId: 1233444 // TODO: In this solution case, we use a predefined queue
};
