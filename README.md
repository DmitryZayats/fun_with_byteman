This writeup assumes using JDK17 from openlogic and all operations will be done from this repo checked out into $HOME

- Clone repo

  ```
  cd ~
  git clone https://github.com/DmitryZayats/fun_with_byteman.git
  cd ~/fun_with_byteman
  ```

- Download JDK17

  ```
  wget https://builds.openlogic.com/downloadJDK/openlogic-openjdk/17.0.14+7/openlogic-openjdk-17.0.14+7-linux-x64.tar.gz
  tar -xzvf openlogic-openjdk-17.0.14+7-linux-x64.tar.gz
  ```

- Download byteman

  ```
  wget https://downloads.jboss.org/byteman/4.0.25/byteman-download-4.0.25-bin.zip
  unzip byteman-download-4.0.25-bin.zip
  ```

- Source file

  ```
  source byteman_sourceme_jdk17.sh
  ```

- Build test application jar with maven
  
  ```
  cd BytemanExampleApp
  mvn package
  ```

- Run Application

  ```
  java -jar target/BytemanExampleApp-1.0-SNAPSHOT-jar-with-dependencies.jar
  ```

- Load byteman agent into running JVM and experiment with byteman rules

  - In another terminal source byteman_sourceme_jdk17.sh file

    ```
    source byteman_sourceme_jdk17.sh
    ```

  - Find pid of the jvm running our Main class

    ```
    ps -ef | grep java | grep BytemanExample | awk '{print $2}'
    ```

  - Install byteman agent into PID of running JVM
 
    ```
    bminstall.sh PID
    ```
  - Load rule
    ```
    bmsubmit.sh TraceFile.btm
    ```
  - Unload rule
    ```
    bmsubmit.sh -u
    ```

  - Try loading / unloading other rules and understand what's happening with the test application


