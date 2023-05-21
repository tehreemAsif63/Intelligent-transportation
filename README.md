# Intelligent transportation



## Getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [ ] [Set up project integrations](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Automatically merge when pipeline succeeds](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing(SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***


## Name

- ### Intelligent Transportation

## Description
- In contemporary society, with the increasing number of cars on the road, the demand for transportation intelligence is also on the rise. Intelligent transportation is designed to leverage technology and algorithms to improve traffic operation efficiency, reduce congestion and improve traffic safety.

- Intelligent transportation systems include three parts: Adaptive Traffic Light System(ATLS), Advanced Driving Assistance System(ADAS), and intelligent transportation application.

- The ATLS is to implement adaptive traffic light adjustment that senses traffic congestion and gives priority to vehicles in the direction of congestion. This can enhance the efficiency of road traffic and reduce congestion.

- With regards to ADAS, distance sensing technology, by detecting surrounding vehicles or objects, can be implemented to help drivers better assess their surroundings. Ideally, early warning systems can be put in place to alert drivers of potential collisions during the driving process, thereby reducing the incidence of traffic accidents and improving driving safety.

- The intelligent transportation app is an application developed based on the Android platform. Users can view the remaining time of the current traffic light, distance sensing information, and real-time alarm information of the car through the APP. Traffic administrator users can use the app to control the current traffic lights.

## Badges
- /appveyor/tests/:user/:repo
- /appveyor/tests/:user/:repo/:branch
- /eclipse-marketplace/dt/:name
- /bitbucket/issues/:user/:repo
- /amo/stars/:addonId
- /bugzilla/:bugNumber

## System design diagram

![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/img/Intelligent%20transportation%20system%20design%20diagram.png)


## Installation

   **1. Install Gitlab on your computer**
   - You can download GitLab from the official website
      - https://about.gitlab.com/install/.

   **2. Install the Arduino IDE**
   - You can download the Arduino IDE from the official website.
      - https://www.arduino.cc/en/software/.

   **3. Install Mosquitto**
   - Mosquitto is an open-source message broker that is used for the communication between devices in the intelligent transportation system. You can download Mosquitto from the official website.
     - https://mosquitto.org/download/.

   **4. Install Android Studio**
   - Android Studio is required to build and run the Android application for the intelligent transportation system. You can download Android Studio from the official website.
     - https://developer.android.com/studio.

   **5. Sign up for Tinkercad**
   - Tinkercad is an online platform that allows you to design and simulate circuits. You can sign up for Tinkercad from the official website.
     - https://www.tinkercad.com/.

   **6. Install MQTTX**
   - Mqtt.x is a cross-platform MQTT client tool used to simplify testing and debugging of the MQTT protocol. 
     - https://mqttx.app/

   **Requirements:**
    1. The intelligent transportation system requires a microcontroller with sensors and actuators to be connected to your computer.
    2. You will need to have a basic understanding of the C++ programming language to use API and libraries.
    3. The Intelligent Transportation System is designed to run on every operating system and on Android applications.

## User Manual
  **To user the Intelligent Transportation System, you will need to follow these steps:**
   **1.Hardware Setup:**
   - Connect the sensors to your Wio terminal following  instructions provided by the system’s manufacturer.Ensure that the connections are made correctly and that the sensors are appropriately powered.You can read about more Wio Terminal in here:
     - https://wiki.seeedstudio.com/Wio-Terminal-Getting-Started/

     ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/wio%20terminal.jpg)
     ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/WioTerminalHardware-Overview.png)
     ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/pinout-diargram.png)
     ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/pinout-diargram-2.png)
     
   **2.Software Setup:**
   - Open theArduino IDE on your computer.
   - Choose the correct port for your connected Arduino board within the Arduino IDE.you can follow these steps:
      1. Click on **Tools > Board Manager** and Search **Seeed SAMD Boards 1.8.3”** version in the Boards Manager.
     
       ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/SeeedSAMD.png)
     
      2. Select your board and port:
         You’ll need to select the entry in the **Tools > Board** menu that corresponds to your Arduino. Selecting the **Wio Terminal**
     
       ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/port-bord.png)
     
   - Download the required libraries and dependencies for the Intelligent Transportation System.
      - For **ATLS**,The Traffic lights system implements traffic lights based on the Red,Yellow,Blue light sensors.And the traffic congestion detected by the Ultrasonic sensors ,To install the Ultrasonic library follow these steps:
         1. Download the UltrasonicRanger Library from Github 
          - https://github.com/Seeed-Studio/Seeed_Arduino_UltrasonicRanger/archive/master.zip.
         2. Refer how to install library for Arduino
          - https://wiki.seeedstudio.com/How_to_install_Arduino_Library
        
      - For **ADAS**,The system will use distance seeing technology to detect front and back of the vehicles by the Ultrasonic sensors,Provide color vision warnings to drivers of potential collisions. and Find the car detected by Buzzer sensors.
        you can read more about LED sensor,Buzzer sensor:
          - https://wiki.seeedstudio.com/Grove-Red_LED/
          - https://wiki.seeedstudio.com/Grove-Buzzer/

   - For Wio Terminal Install Library **"rpcUnified"** from Arduino Library Manager,follow these steps:
        1. Click **Sketch > Include Library > Manage Libraries**… …
        2. Type the name of the library **"rpcUnified”** hat we need and select the latest vision from the drop-down menu(if available)
        3. Click Install:
     
     ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/rpcUnified.png)
     
   - For Wi-Fi on the WioTerminal.You can search for **"seeed rpcwifi"** library by typing the library name in the search box of **Arduino Library Manager**

     ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/rpcWifi.png)

   - For send and receive MQTT messages Install the library **"PubSubClient”**,You can search by typing the library name in the search box of **Arduino Library Manager**.

     ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/pubsubClient.png)

   **3. Code Compilation and Upload:**
   - Once the code compiles successfully,upload it to the Wio terminal or the Arduino board you are using.

   **4. Message Broker Setup:**
   - Install and run Mosquitto, a message broker,on your computer. This facilitates communication between the Android application and the hardware system.

   **5. Android Studio Setup:**
   - Set up an Android Virtual Device(AVD) minimum API 30.
   - Configure the Android development environment to include the MQTT dependencies.
      - Add the following libraries to your project:
     

        org.eclipse.paho.android.service-1.1.1.jar
        org.eclipse.paho.client.mqttv3-1.2.5.jar

   ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/librs.png)
   - Define build configuration by following these:

   ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/Configuration.png)
   - Add Paho repository,Click **settings.gradle** add

           maven {
            url "https://repo.eclipse.org/content/repositories/paho-snapshots/"**
           }

   ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/PahoRepository.png)

   - In order to enable App to bind to Paho Android Service, the following information needs to be added in **AndroidManifest.xml**

        <uses-permission android:name="android.permission.WAKE_LOCK" />
        <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
        <uses-permission android:name="android.permission.INTERNET" />
        <uses-permission android:name="android.permission.READ_BASIC_PHONE_STATE" />

   ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/PahoAnroidService.png)

   - Declare the following services in **AndroidManifest.xml**

        <service android:name="org.eclipse.paho.android.service.MqttService" />

   ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/AndroidManifest.png)
   - For used of  the Paho allowing  the MQTT connection

   ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/MQTTconnection.png)

   **6. Build and run the Android application on your device or emulator.**

   **7. Control and Monitoring**
   - Once the Android application is running on your device, you can use it to control and monitor the features of the intelligent Transportation System.The application provides an intuitive interface for sending commands,receiving data, and visualizing sensor readings.


## Support
- **If you need help with the project, you can find support in the following ways:**
 1. Chat room: You can join the chat room on Discord to ask questions and discuss the project with the following developers:
   https://discord.gg/KN5YJ7TU
 2. Slack : If you prefer to communicate via Slack , you can send a message to the TA or teacher.



## Roadmap

 **Research and Planning:**
  - Conduct a comprehensive analysis of traffic patterns,congestion hotspots,and existing transportation infrastructure.identify key goals and objectives for the intelligent transportation system implementation.
  - Evaluate available technologies,sensors, and communication protocols suitable for the system.

 **Set Up GitLab:**
  - Set up a GitLab repository for version control and collaboration.
  - Create a WiKi pages in the gitlab repository to document project information and procedures.
  - Utilize Gitlab’sMilestones feature to track project progress
  - Create Issues in GitLab to track and manage tasks,bugs,and feature requests.
  - Assign team members to specific Issues and track their progress.
  - Every two weeks update the Wiki pages with relevant project documentation, progress of project, and project updates.
  - User Gitlab’s collaboration features,such as merge requests and code reviews, to censure code quality and collaboration among team members
  - Manage the gitlab repository, addressing any issues or conflicts that arise during development.  
  - Document and version control the project’s source code,ensuring proper branching and merging strategies.

 **System Design and Architecture:**
  - Design the overall architecture of the intelligent transportation system, including the integration of various components such as traffic light,sensors, and user interfaces.
  - Define communication protocols and data formats for seamless interaction between different system elements.
  - Create a detailed design specification document outlining system requirements, functionalities, and interfaces.

 **Development and Testing:**
  - Develop and implement the Adaptive Traffic Light System, which automatically adjusts traffic signals based on real-time road conditions and congestion levels.
  - Develop and implement the Control Traffic Light functionality,allowing traffic administrators to manually adjust traffic signal settings when congestion reaches critical levels.
  - Develop and implement the Warning Display feature,which detects potential accidents using sensors and triggers audible warnings accompanied by Color changes in the app.
  - Develop and implement the Car Finding functionality,enabling users to locate their vehicles with a single button press on the Android application
  - Conduct unit testing for individual software modules to verify their functionality and correctness.
  - Perform integration testing to ensure seamless interaction between different system components.
  - Conduct system-level testing to evaluate the overall performance, reliability, and user experience of the developed features.


## Contributing
- Start with forking the repository and create a new branch for the changes you want to make. You need to have a GitHub account and then press the  "Fork" button in the top-right corner which will create a copy of the project.
- Ensure the code does not break the project's guideline, after you make the changes
- Make the changes and keep on testing the project. We recommend creating a new branch to separate the project code and your changes.
- Add comments and documentation if you needed to classify the changes
- Make a pull request to the projects main repository for the developers review.


## Authors and acknowledgment
- Yingchao Ji         gusjiyid@student.gu.se
- Hassan Saleh        gussalhaf@student.gu.se
- Jessie Johnsson     gusjohjefh@student.gu.se
- Tehreen Asif        gusasite@student.gu.se
- Elif Sayeed Yaqoud  gussayel@student.gu.se



## License
This projects is licensed under the University of Gothenburg and Chalmers License
Feel free to modify and adapt the Intelligent Transportation System to suit your needs.Contributions are welcome, and any issues or suggestions can be reported in the issue tracker.

## Project status
The project is continuous and it is in development. All developers are working efficiently and constantly to improve and release the system. 