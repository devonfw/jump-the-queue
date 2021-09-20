export const environment: {
  production: boolean;
  baseUrlRestServices: string;
  security: 'jwt' | 'csrf';
} = {
  production: true,
  baseUrlRestServices: 'http://localhost:8081/jumpthequeue/services/rest',
  security: 'csrf'
};
