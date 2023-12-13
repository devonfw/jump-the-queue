# FRONT-END DOCKERFILE JTQ
# /angular directory

# FIRST STAGE - Building Angular app

# Use an official Node.js runtime as a base image
FROM node:latest AS build-step

# Set the working directory in the container
# RUN mkdir -p /app
WORKDIR /app

# Copy package.json and yarn.lock to the working directory (/app)
COPY package.json .
COPY yarn.lock .

# Install project dependencies
RUN yarn install --force

# Copy the rest of the application code (take in account the .dockerignore file)
# from /angular (host) to /app (container)
COPY . .

# Build the Angular app for production stage
RUN yarn run build --prod 
# the /dist directory has been built out

############################

# SECOND STAGE - Production (Launching app in web server - NGINX)

FROM nginx:latest AS production-step
#FROM tomcat:latest AS production-step

# Copy from the Angular app (container) to the web server    
COPY --from=build-step /app/dist/angular /usr/share/nginx/html
# COPY --from=build-step /app/dist/angular /usr/share/tomcat/webapps

# Expose port 80, not neccesary, the 80 is exposed by default in the nginx image (see Docker Hub)
# EXPOSE 80

# Define the command to run the application, not necessary with the NGINX image for serving static files
# CMD ["ng", "serve", "--host", "0.0.0.0"]
