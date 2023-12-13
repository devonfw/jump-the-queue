export const environment: {
  production: boolean;
  baseUrlRestServices: string;
  security: 'jwt' | 'csrf';
} = {
  production: true,
  baseUrlRestServices: 'http://localhost:8081/jumpthequeue/services/rest',   
  security: 'csrf'
};


// Para imagen en docker-compose para reverse-proxy:
// http://localhost:8082/backend/

// Para imagen de en kubernetes:
// baseUrlRestServices: 'http://be-service:8081/jumpthequeue/services/rest'