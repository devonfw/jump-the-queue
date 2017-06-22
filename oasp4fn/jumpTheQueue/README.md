## Installation

### Dependencies

No more dependencies out of the package.json are needed, so the first command required for the installation is:

    $ npm install

or

    $ yarn

Although, for the environment to work properly, some packages have to be installed globally, so you have to execute these commands next:

    $ npm install -g mocha

    $ npm install -g ts-node

    $ npm install -g typescript

    $ npm install -g serverless

## Execution

### OASP4Fn

Execute the command:

    $ npm run fun

This command will generate the necessary files to deploy and build your handlers. Optionally you can add an option to the last command to additionally generate an app.ts file to execute the handlers through a local express server:

    $ npm run fun -- -e

Though that isn't necessary because the serverless framework has a plugin that emulates an api gateway locally.

### Build

To build the typescript sources only is necessary to run:

    $ npm run build

### Start

To start the service locally there are two possibilities:

1. Use the plugin serverless-offline (Recommended):

    $ npm run offline

2. Use the generated app.ts (only if you execute ```npm run fun -- -e``` in the previous step:

    $ npm run start

### Testing

You can test the correct behaviour of the business logic using the command:

    $ npm run test

Also, you can visualize if some of the changes are going wrong when you save it, without executing every time the previous command, to do this you can run the next command on a new shell:

    $ npm run test:auto