export const environment: {
  production: boolean;
  baseUrlRestServices: string;
  security: 'jwt' | 'csrf';
} = {
  production: false,
  baseUrlRestServices: 'http://localhost:8081/jumpthequeue/services/rest',
  security: 'csrf'
};
