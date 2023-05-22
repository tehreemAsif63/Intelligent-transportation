# Intelligent Transportation

## Table of Content
- [Getting started](#getting-started)
- [Description](#description)
- [Features](#features)
- [Purpose & Benefits](#purpose-&-benefits)
- [Demo Video](#demo-video)
- [Visuals](#visuals)
- [System design](#system-design-diagram)
- [Installation](#installation)
- [Usage](#usage)
- [User Manual](#user-manual)
- [Roadmap](#roadmap)
- [Contribute](#contribute)
- [Authors and acknowledgment](#authors-&-acknowledgment)
- [License](#license)
- [Project status](#project-status)

## Getting started
- To begin working on Intelligent Transportation, it is essential to have access to GitLab. If you don't have an account already, please create one by following the recommended steps to gain access.
- If you are already experienced in this field, feel free to customize and modify this README.md file according to your needs. Make sure to document all the changes you make for reference.
- To simplify the process, you can utilize the template provided below:

## Name

- # Intelligent Transportation

## Description
- Traffic management can pose significant challenges, especially in today's society where the number of vehicles on the roads has exponentially increased. Intelligent transportation, with its sophisticated algorithms and advanced management systems, offers a solution to this pressing issue. By incorporating various functionalities, it effectively aids in traffic management, accident prevention, and overall vehicle efficiency.

- The Adaptive Traffic Light System is a pivotal component that adjusts traffic lights based on real-time road conditions and congestion levels. By prioritizing areas with high congestion, it optimizes traffic flow and minimizes time wasted during peak hours.

- The Control Traffic Light functionality provides a more flexible approach, allowing traffic administrators to manually adjust traffic light settings when congestion reaches critical levels. While general users can view the traffic flow, administrators have the authority to modify it, ensuring smoother traffic management.

- To enhance driving safety, the Warning Display feature employs sensors to detect potential accidents. When a vehicle approaches a hazardous distance, an audible warning is triggered, accompanied by a color change in the app, indicating the level of danger based on proximity to other objects and vehicles.

- In large parking lots, finding a misplaced vehicle can be a daunting task. However, the Car Finding functionality simplifies the process. With just a single button press on the Android application, a sound is emitted, guiding the user towards their vehicle's location.

- These comprehensive features of the intelligent transportation system demonstrate its effectiveness in addressing traffic management challenges, promoting safety, and facilitating efficient vehicle navigation.

## Features

- **Normal Traffic Light**
    - General traffic light system that changes light automatically just like normal

- **Adaptive Traffic Tight**
    - Traffic light system that adapts to the traffic light flow and changes lights when congestions happen

- **Control Traffic Light**
    - The traffic administrator can control the traffic light system when the traffic is crowded to prevent congestions and queuing

- **Car Finding**
    - The vehicle makes a buzzer sound when the user is unable to find the vehicle nearby

- **Warning Display**
    - Displays a warning for approaching vehicles with different colors depending on the vehicles distance

## Purpose & Benefits

**Purpose**
- Intelligent Transportation is a practical solution to the everyday challenges faced in traffic situations. It addresses the issues of congestion, accidents, and time management that occur on a daily basis.
- Our project focuses on leveraging intelligent transportation systems and cutting-edge technology to achieve several key objectives. Firstly, we aim to enhance the efficiency of traffic operations, ensuring smoother flow and minimizing congestion. By incorporating advanced algorithms, adaptive traffic light systems, and an intuitive Android application, we strive to optimize traffic management processes.
- Furthermore, our project places a strong emphasis on improving traffic safety. Through the integration of intelligent systems and real-time monitoring, we aim to reduce the occurrence of accidents and mitigate potential risks on the road.
- Ultimately, our overarching goal is to create a transportation network that is both highly efficient and significantly safer. By enhancing the overall commuting experience for drivers, passengers, and traffic administrators, we aim to contribute to a more sustainable and enjoyable urban environment.

**Benefits**
- Intelligent Transportation offers numerous benefits that significantly improve various aspects of transportation systems:
- Improved Traffic Flow: Implementation of intelligent transportation systems, including adaptive traffic light adjustment, aims to enhance traffic flow and alleviate congestion. This results in smoother and more efficient travel experiences for drivers, reducing delays and frustrations commonly associated with heavy traffic.
- Enhanced Safety: By incorporating the Advanced Driving Assistance System (ADAS) and real-time alerts into the Android application, our project prioritizes road safety. The ADAS provides drivers with distance sensing and early warning systems, effectively reducing the risk of collisions and accidents. Additionally, real-time alerts keep users informed about potential hazards, road conditions, and other safety-related information, further enhancing overall safety.
- Optimized Resource Utilization: The project focuses on intelligent traffic management and prioritization to maximize the utilization of transportation resources. By minimizing congestion and improving traffic flow efficiency, our system contributes to reduced fuel consumption, lower emissions, and a more sustainable and environmentally friendly transportation system.
- User-Friendly Interface: The Android application developed as part of the project boasts a user-friendly interface. Notable features, such as the intuitive car console, convenient sign-up and login pages, provide users with seamless access to relevant functionalities. This user-friendly design enhances the overall user experience and facilitates easy interaction with the transportation system.
- Collaborative Approach: Our project adopts a collaborative approach, where team members actively contribute to both Arduino code and Android app development. This fosters a holistic understanding of the project, promotes knowledge sharing, skill development, and effective teamwork. By leveraging the collective expertise of the team members, we ensure a comprehensive and robust implementation of the intelligent transportation system.
- Overall, Intelligent Transportation brings forth a host of benefits, including improved traffic flow, enhanced safety measures, optimized resource utilization, a user-friendly interface, and a collaborative development approach. These advancements collectively contribute to an efficient, safe, and sustainable transportation ecosystem.

## Demo Video
 - https://www.youtube.com/watch?v=IZmz6ns-CH4

## System design

-  **System design diagram**

   ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/SystemDiagram.png)

-  **hardware architecture diagram**

   ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/hardware_architecture.png)

-  **software architecture diagram**

   ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/software_architecture.png)

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
   3. The Intelligent Transportation System is designed to run on Android applications.

## Usage
  #### To user the Intelligent Transportation System, you will need to follow these steps:

   **1.Hardware Setup:**
   - Connect the sensors to your Wio terminal following  instructions provided by the system’s manufacturer.Ensure that the connections are made correctly and that the sensors are appropriately powered.You can read about more Wio Terminal in here:
     - https://wiki.seeedstudio.com/Wio-Terminal-Getting-Started/

     ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/wioTerminalOverview.png)
     
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

        - org.eclipse.paho.android.service-1.1.1.jar
        - org.eclipse.paho.client.mqttv3-1.2.5.jar

   ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/librs.png)
   - Define build configuration by following these:

   ![image](https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/raw/main/Android/img/Configuration.png)
   - Add Paho repository,Click **settings.gradle** add

           maven {
            url "https://repo.eclipse.org/content/repositories/paho-snapshots/"
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

## User Manual
 **Using intelligent transportation app**
 - Click on this link to Wiki page to access the instructions for using the app:
   - https://git.chalmers.se/courses/dit113/2023/group-9/intelligent-transportation/-/wikis/uploads/9ee86d8f70a309be6aeae77434de81b5/USER_MANUAL.docx.pdf

## Roadmap

#### Research and Planning:
  - Conduct a comprehensive analysis of traffic patterns,congestion hotspots,and existing transportation infrastructure.identify key goals and objectives for the intelligent transportation system implementation.
  - Evaluate available technologies,sensors, and communication protocols suitable for the system.

#### Set Up GitLab:
  - Set up a GitLab repository for version control and collaboration.
  - Create a WiKi pages in the gitlab repository to document project information and procedures.
  - Utilize Gitlab’sMilestones feature to track project progress
  - Create Issues in GitLab to track and manage tasks,bugs,and feature requests.
  - Assign team members to specific Issues and track their progress.
  - Every two weeks update the Wiki pages with relevant project documentation, progress of project, and project updates.
  - User Gitlab’s collaboration features,such as merge requests and code reviews, to censure code quality and collaboration among team members
  - Manage the gitlab repository, addressing any issues or conflicts that arise during development.  
  - Document and version control the project’s source code,ensuring proper branching and merging strategies.

#### System Design and Architecture:
  - Design the overall architecture of the intelligent transportation system, including the integration of various components such as traffic light,sensors, and user interfaces.
  - Define communication protocols and data formats for seamless interaction between different system elements.
  - Create a detailed design specification document outlining system requirements, functionalities, and interfaces.

#### Development and Testing:
  - Develop and implement the Adaptive Traffic Light System, which automatically adjusts traffic signals based on real-time road conditions and congestion levels.
  - Develop and implement the Control Traffic Light functionality,allowing traffic administrators to manually adjust traffic signal settings when congestion reaches critical levels.
  - Develop and implement the Warning Display feature,which detects potential accidents using sensors and triggers audible warnings accompanied by Color changes in the app.
  - Develop and implement the Car Finding functionality,enabling users to locate their vehicles with a single button press on the Android application
  - Conduct unit testing for individual software modules to verify their functionality and correctness.
  - Perform integration testing to ensure seamless interaction between different system components.
  - Conduct system-level testing to evaluate the overall performance, reliability, and user experience of the developed features.

## Contribute
- We value and appreciate contributions from the open-source community to enhance our project. Your involvement can make a significant difference by improving functionality, introducing new features, and enhancing the overall user experience.
- To contribute, we kindly ask you to follow the guidelines outlined below:

#### Code Guidelines 
- To ensure consistency and readability throughout the project, we kindly ask you to adhere to our coding guidelines when submitting your code contributions. These guidelines encompass the following best practices
 - Use meaningful and descriptive variable and function names to enhance code clarity.
 - Include necessary comments where the code is complex to aid in understanding.
 - Follow proper indentation practices for improved code readability.
 - Provide clear and concise commit messages that describe the purpose of your changes.
 - As a precaution, push your code to your own branch to prevent any potential errors and bugs from affecting the main codebase.

#### Pull request
- We encourage you to contribute code to the project by submitting a pull request. Your contributions can have a direct impact on the project's growth and success. To submit a pull request, please follow these steps
 - Start with forking the repository and create a new branch for the changes you want to make.
 - You need to have a GitHub account and then press the  "Fork" button in the top-right corner which will create a copy of the project.
 - Ensure the code does not break the project's guideline, after you make the changes
 - Make the changes and keep on testing the project. We recommend creating a new branch to separate the project code and your changes.
 - Add comments and documentation if you needed to classify the changes
 - Write clear and concise commit messages
 - Submit a pull request to the project's main branch in the repository for the developers to review.

#### Communication
- If you have any questions, feedback, or require assistance, please don't hesitate to reach out to us. You can contact one of our developers directly via email which is provided below in Author and acknowledgement or join our Discord community. We highly value your input and assure you that we will respond promptly to address any queries or concerns you may have.
- Discord Community
  - https://discord.gg/PbDeME76
- We sincerely appreciate your interest in contributing to our project, and we eagerly anticipate the opportunity to collaborate with you to further enhance its capabilities. Together, we can make it even better!


## Authors & acknowledgment
- The project was a sophisticated undertaking that required significant team effort to complete. Every group member contributed to various aspects of the project,leveraging their diverse skills in design, coding, and development.
- Each team member had the opportunity to work on Arduino code, Android app development, and documentation, ensuring a well-rounded understanding of the project. This approach fostered a collaborative environment where members could leverage their diverse skills and knowledge to contribute effectively.
- This collaborative approach allowed for a well-rounded execution of the project, with every member actively involved in Android Studio code development, Arduino code development, and documentation. To ensure comprehensive coverage, the project was divided into two main areas of focus: Arduino code and Android Studio code.

- **Yingchao Ji**:
  - He was involved in the early stages of the project, contributing to project design and requirements analysis. He created a project structure diagram, defined milestones, and some parts of issues. And he took responsibility for the initial architectural design of the project.
  - During the implementation of the Android code, he focused on two specific modules: the traffic light module and the car console module. For the traffic light module, he completed the page implementation and enabled dynamic page display through MQTT integration. For the car console module, he implemented the page and dynamic distance data.
  - For Arduino code implementation, he collaborated with other group members to implement the adaptive traffic light functionality. And working on callback functions to receive messages. Furthermore, he worked with Jessie to implement the car distance sensing code.
  - He established the MQTT connection, setting up the MQTT environment with Jessie by and ensuring its proper implementation.
  - For hardware connectivity, he actively participated in connecting and testing individual sensors.
  - When it came to project documentation, he played a role in producing wiki pages and the README file and created the project demonstration video.
  - In the final sprint of the project, he participated in merges and updates to ensure smooth integration. He also fixes some bugs to ensure good performance of the project.
- **Hassan Saleh**: 
  - Hassan Saleh's primary focus in development revolved around crafting visually appealing user interfaces for the Android application. 
  - Among his notable contributions were the creation of a captivating warning console and an engaging sign-up prompt. 
  - Additionally, he played a pivotal role in the development of the control traffic light system, where he leveraged the Arduino IDE to implement intricate logic and algorithms.
- **Jessie Johnsson**:
  - She actively participated in the early stages of requirement analysis and utilized her skills in problem analysis to clarify project requirements. She created user stories ,README file ,wiki pages and project completion reports to plan sprint iterations, ensuring timely project delivery.
  - In the hardware domain, she was involved in the installation and layout of hardware devices, fulfilling material requirements, and successfully implementing the configuration of Adruino boards and interfaces, guaranteeing the smooth operation of the system.
  - On the software side, she  configuried the Adruino environment and installing relevant libraries. She leveraged ultrasonic sensors to achieve reliable data transmission and subscription, enabling seamless communication with the server.
  - Furthermore, she designed and implemented a stylish and dynamic interface for the Android application. Using the MQTT protocol, she established data communication between the Android application and the server. She configured the necessary development tools, SDKs, and dependencies, and installed appropriate libraries and components to ensure the proper functioning of the application.
  - Within the team, she actively assisted team members in analyzing and resolving project bugs, as well as handling conflicts during project merges. Her contributions helped the team overcome technical challenges and drove the progress of the project.
- **Tehreen Asif**:
  - Tehreem Asif made significant contributions to multiple aspects of the project. 
  - She played a pivotal role in implementing the normal traffic light system and defining the traffic light sequence. She also contributed to developing the necessary logic for the Android app and helped with the adaptive traffic light system.
  - Additionally, she actively participated in shaping the project's requirements and user stories, contributed to documentation and wiki updates, improved the visual appeal of the car console pages, and established the car finding functionality through MQTT connection. 
  - Tehreem's dedication extended to fixing, updating, and proofreading the app's readme file, as well as creating a comprehensive user manual.
- **Elif Sayeed Yaqoud**:
  - She made significant contributions to the functionality of the app by developing essential features, including a versatile login system tailored for various user types. To ensure seamless data management, 
  - She implemented a JSON file structure to securely store user information. Additionally, she designed an appealing layout that enhances the user experience. Moreover,she created a captivating splash screen that showcases the app's logo and name, providing an engaging start to the Android application. 
  - In the Arduino realm, she played a crucial role in integrating an ultrasound sensor, enabling real-time monitoring of passing vehicles to detect and analyze potential traffic congestion on the roadway. Beyond the technical aspects.
  - She actively participated in the project's documentation efforts, assuming responsibility for capturing comprehensive requirements and user stories. I consistently updated and improved the project's wiki page, contributing to the overall success of the endeavor. Additionally, I dedicated substantial effort to crafting a user-friendly and informative user manual, facilitating ease of use and assisting end-users in maximizing their experience with the application.

- Furthermore, the entire team actively contributed to the documentation process. They documented their code, processes, challenges faced or lessons learnt and project findings, ensuring that valuable insights and instructions were available for future reference. This comprehensive documentation not only served as a knowledge base but also facilitated effective collaboration within the team.

- **Project members**
- Yingchao Ji                      <gusjiyid@student.gu.se>
- Hassan Saleh                     <gussalhaf@student.gu.se>
- Jessie Johnsson                  <gusjohjefh@student.gu.se>
- Tehreem Asif                     <gusasite@student.gu.se>
- Elif Sayeed Yaqoud               <gussayel@student.gu.se>

## License
 - This projects is licensed under the **University of Gothenburg and Chalmers** License
 - Feel free to modify and adapt the Intelligent Transportation System to suit your needs.Contributions are welcome, and any issues or suggestions can be reported in the issue tracker.

## Project status
- The project has reached its completion, with all developers working diligently and efficiently to deliver the system.
