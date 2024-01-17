# Jump The Queue

## Source code and documentation for the _JumpTheQueue_ tutorial application.  
#Documentation is provided in the form of a step-by-step guide suited for new devonfw users.

## **Building application on local**

To build application on local execute below commands:

1. Download latest devonfw-ide from [here](https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=com.devonfw.tools.ide&a=devonfw-ide-scripts&v=LATEST&p=tar.gz). More details to setup devonfw -ide can be found [here](https://devonfw.com/website/pages/docs/setup.asciidoc.html).

2. Once ide setup is done. Clone jump-the-queue application in workspace:
   
      --`git clone https://github.com/devonfw/jump-the-queue.git`
      
3. ** Building and running Jump-the-queue backend:**

    To build backend navigate to `jump-the-queue\java\jtqj` folder from command line and execute command `mvn clean install`.
    
    To run BE using jar navigate to `jump-the-queue\java\jtqj\server\target` from command line and execute `java -jar jtqj-server-bootified.war` <br/>
    OR</br>
    Alternatively, you can launch application using mvn spring-boot:run command. Navigate to `jump-the-queue\java\jtqj\core` folder from command line and execute `mvn spring-boot:run`
 added and test    
4.  **Build Jump-the-queue front-end:**
    Install first node
    To build Jump-the-queue front-end navigate to `jump-the-queue\angular` folder from command line and execute command `yarn install --force`.
    To launch jump-the-queue FE navigate to `jump-the-queue\angular` folder from command line and execute `yarn start`.
	Alternatively, you can use npm if you face issues with yarn (build using `npm install --force` and launch using `npm start`).
    
5.  **Access the application.**

    While registering user or login if you get access error check on browser console if you are getting CORS related issue. Clear the browser cache and try once again. Or    remove `security.cors.spring.allowedOriginPatterns=*` and add `security.cors.spring.allowedOrigins=http://localhost:4200`. localhost:4200 is default port where angular application starts in case you have changed port please change it in respective property as well.
    

Please visit the [wiki](https://github.com/devonfw/devonfw-tutorial-sources/wiki) tab to begin the walkthrough.
