# Intelligent transportation



## Getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#contribute)!

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


# **Intelligent Transportation**

## Table of Content
- [Features](#features)
- [Purpose & Benefits](#purpose-&-benefits)
- [Description](#description)
- [Badges](#badges)
- [Visuals](#system-design-diagram)
- [Installation](#installation)
- [Usage](#usage)
- [Roadmap](#roadmap)
- [Contribute](#contribute)
- [Authors and acknowledgment](#authors-and-acknowledgment)
- [License](#license)
- [Project status](#project-status)
  
## Features

- | Normal traffic light     | General traffic light system that changes light automatically just like normal|
- | Adaptive traffic light   | Traffic light system that adapts to the traffic light flow and changes lights when congestions happen|
- | Control traffic light    | The traffic administrator can control the traffic light system when the traffic is crowded to prevent congestions and queuing|
- | Car finding              |The vehicle makes a buzzer sound when the user is unable to find the vehicle nearby|
- | Warning display          |Displays a warning for approaching vehicles with different colors depending on the vehicles distance|

## Purpose & Benefits
- Intelligent Transportation is a practical solution to the everyday challenges faced in traffic situations. It addresses the issues of congestion, accidents, and time management that occur on a daily basis.
- Our project focuses on leveraging intelligent transportation systems and cutting-edge technology to achieve several key objectives. Firstly, we aim to enhance the efficiency of traffic operations, ensuring smoother flow and minimizing congestion. By incorporating advanced algorithms, adaptive traffic light systems, and an intuitive Android application, we strive to optimize traffic management processes.
- Furthermore, our project places a strong emphasis on improving traffic safety. Through the integration of intelligent systems and real-time monitoring, we aim to reduce the occurrence of accidents and mitigate potential risks on the road.
- Ultimately, our overarching goal is to create a transportation network that is both highly efficient and significantly safer. By enhancing the overall commuting experience for drivers, passengers, and traffic administrators, we aim to contribute to a more sustainable and enjoyable urban environment.

- **Intelligent Transportation offers numerous benefits that significantly improve various aspects of transportation systems:**
- Improved Traffic Flow: Implementation of intelligent transportation systems, including adaptive traffic light adjustment, aims to enhance traffic flow and alleviate congestion. This results in smoother and more efficient travel experiences for drivers, reducing delays and frustrations commonly associated with heavy traffic.
- Enhanced Safety: By incorporating the Advanced Driving Assistance System (ADAS) and real-time alerts into the Android application, our project prioritizes road safety. The ADAS provides drivers with distance sensing and early warning systems, effectively reducing the risk of collisions and accidents. Additionally, real-time alerts keep users informed about potential hazards, road conditions, and other safety-related information, further enhancing overall safety.
- Optimized Resource Utilization: The project focuses on intelligent traffic management and prioritization to maximize the utilization of transportation resources. By minimizing congestion and improving traffic flow efficiency, our system contributes to reduced fuel consumption, lower emissions, and a more sustainable and environmentally friendly transportation system.
- User-Friendly Interface: The Android application developed as part of the project boasts a user-friendly interface. Notable features, such as the intuitive car console, convenient sign-up and login pages, provide users with seamless access to relevant functionalities. This user-friendly design enhances the overall user experience and facilitates easy interaction with the transportation system.
- Collaborative Approach: Our project adopts a collaborative approach, where team members actively contribute to both Arduino code and Android app development. This fosters a holistic understanding of the project, promotes knowledge sharing, skill development, and effective teamwork. By leveraging the collective expertise of the team members, we ensure a comprehensive and robust implementation of the intelligent transportation system.
- Overall, Intelligent Transportation brings forth a host of benefits, including improved traffic flow, enhanced safety measures, optimized resource utilization, a user-friendly interface, and a collaborative development approach. These advancements collectively contribute to an efficient, safe, and sustainable transportation ecosystem.

## Description
- Traffic management can pose significant challenges, especially in today's society where the number of vehicles on the roads has exponentially increased. Intelligent transportation, with its sophisticated algorithms and advanced management systems, offers a solution to this pressing issue. By incorporating various functionalities, it effectively aids in traffic management, accident prevention, and overall vehicle efficiency.

- The Adaptive Traffic Light System is a pivotal component that adjusts traffic lights based on real-time road conditions and congestion levels. By prioritizing areas with high congestion, it optimizes traffic flow and minimizes time wasted during peak hours.

- The Control Traffic Light functionality provides a more flexible approach, allowing traffic administrators to manually adjust traffic light settings when congestion reaches critical levels. While general users can view the traffic flow, administrators have the authority to modify it, ensuring smoother traffic management.

- To enhance driving safety, the Warning Display feature employs sensors to detect potential accidents. When a vehicle approaches a hazardous distance, an audible warning is triggered, accompanied by a color change in the app, indicating the level of danger based on proximity to other objects and vehicles.

- In large parking lots, finding a misplaced vehicle can be a daunting task. However, the Car Finding functionality simplifies the process. With just a single button press on the Android application, a sound is emitted, guiding the user towards their vehicle's location.

- These comprehensive features of the intelligent transportation system demonstrate its effectiveness in addressing traffic management challenges, promoting safety, and facilitating efficient vehicle navigation.

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
1. Install Gitlab on your computer 
* You can download GitLab from the official website: https://about.gitlab.com/install/.
2. Install the Arduino IDE
 - You can download the Arduino IDE from the official website: https://www.arduino.cc/en/software/.
3. Install Mosquitto
 - Mosquitto is an open-source message broker that is used for the communication between devices in the intelligent transportation system. You can download Mosquitto from the official website: https://mosquitto.org/download/.
4. Install Android Studio
 - Android Studio is required to build and run the Android application for the intelligent transportation system. You can download Android Studio from the official website: https://developer.android.com/studio.
5. Sign up for Tinkercad and connect your microcontroller and sensors to your computer.
 - Tinkercad is an online platform that allows you to design and simulate circuits. You can sign up for Tinkercad from the official website: https://www.tinkercad.com/.
   Follow the instructions provided by Tinkercad to connect your microcontroller and sensors to your computer.

**Requirements:**
  1. The intelligent transportation system requires a microcontroller with sensors and actuators to be connected to your computer.
  2. You will need to have a basic understanding of the C++ programming language to use API and libraries.
  3. The Intelligent Transportation System is designed to run on every operating system and on Android applications.

## Usage
- **To user the Intelligent Transportation System, you will need to follow these steps:**
  1. Connect the microcontroller and sensors to your computer according to the instructions provided by Tinkercad.
  2. Open the Arduino IDE and load the project file either ATLS or ADAS, depending on which feature you want to use.
  3. Compile and upload the code to the microcontroller
  4. Run Mosquitto message broker on your computer to facilitate communication between devices.
  5. Open Android Studio project for the Intelligent Transportation System.
  6. Build and run the Android application on your device.
  7. Use the app to control and monitor the features of the Intelligent Transportation System.
  
- **For ATLS, the system will automatically adjust the timing of the traffic lights based on traffic congestion detected by the sensors.** 
- **For ADAS, the system will use distance seeing technology to detect surrounding vehicles or objects and provide early warnings to drivers of potential collisions.**

## Roadmap
- **As of now we focus on releasing and improving the Intelligent Transportation project but the developers have come up with future releases and features. We welcome feedback and suggestions from the community, and we will continue to work towards improving and expanding the functionality of the Intelligent Transportation system. Here is the following list:**
 1. Integration with more sensor types: Currently, the project relies on a limited set of sensors to gather information about the environment. In future releases, we plan to expand the range of sensors that can be used, such as adding cameras or lidar sensors.
 2. Improved machine learning algorithms: The project currently uses machine learning algorithms to analyze traffic data and make predictions about traffic patterns. In future releases, we plan to refine these algorithms and integrate more advanced techniques to improve accuracy and efficiency. 
 3. Integration with smart city infrastructure: To fully realize the potential of intelligent transportation, it is important to integrate the project with other smart city infrastructure, such as traffic cameras, traffic management systems, and public transportation systems. In future releases, we plan to work towards this goal and enable seamless integration with these systems.
 4. Expansion of ADAS features: The Advanced Driving Assistance System (ADAS) currently includes basic distance sensing technology. In future releases, we plan to expand the range of features to include other safety features, such as lane departure warnings and automatic emergency braking.


## Contribute
- We value and appreciate contributions from the open-source community to enhance our project. Your involvement can make a significant difference by improving functionality, introducing new features, and enhancing the overall user experience.
- To contribute, we kindly ask you to follow the guidelines outlined below:

#### Code Guidelines 
- To ensure consistency and readability throughout the project, we kindly ask you to adhere to our coding guidelines when submitting your code contributions. These guidelines encompass the following best practices:
* Use meaningful and descriptive variable and function names to enhance code clarity.
* Include necessary comments where the code is complex to aid in understanding.
* Follow proper indentation practices for improved code readability.
* Provide clear and concise commit messages that describe the purpose of your changes.
* As a precaution, push your code to your own branch to prevent any potential errors and bugs from affecting the main codebase.

#### Pull request
- We encourage you to contribute code to the project by submitting a pull request. Your contributions can have a direct impact on the project's growth and success. To submit a pull request, please follow these steps:
* Start with forking the repository and create a new branch for the changes you want to make.
* You need to have a GitHub account and then press the  "Fork" button in the top-right corner which will create a copy of the project.
* Ensure the code does not break the project's guideline, after you make the changes
* Make the changes and keep on testing the project. We recommend creating a new branch to separate the project code and your changes.
* Add comments and documentation if you needed to classify the changes
* Write clear and concise commit messages
* Submit a pull request to the project's main branch in the repository for the developers to review.

#### Communication
- If you have any questions, feedback, or require assistance, please don't hesitate to reach out to us. You can contact one of our developers directly via email which is provided below in Author and acknowledgement or join our Discord community. We highly value your input and assure you that we will respond promptly to address any queries or concerns you may have.

- Discord Community: [Click here](https://discord.gg/PbDeME76)

- We sincerely appreciate your interest in contributing to our project, and we eagerly anticipate the opportunity to collaborate with you to further enhance its capabilities. Together, we can make it even better!


## Support
- **If you need help with the project, you can find support in the following ways:**
1. Chat room: You can join the chat room on Discord to ask questions and discuss the project with the following developers:
   https://discord.gg/KN5YJ7TU
2. Slack : If you prefer to communicate via Slack , you can send a message to the TA or teacher.


## Authors and acknowledgment
- The project was a sophisticated undertaking that required significant team effort to complete. Every group member contributed to various aspects of the project,leveraging their diverse skills in design, coding, and development.
- Each team member had the opportunity to work on Arduino code, Android app development, and documentation, ensuring a well-rounded understanding of the project. This approach fostered a collaborative environment where members could leverage their diverse skills and knowledge to contribute effectively.
- This collaborative approach allowed for a well-rounded execution of the project, with every member actively involved in Android Studio code development, Arduino code development, and documentation. To ensure comprehensive coverage, the project was divided into two main areas of focus: Arduino code and Android Studio code.
- Hassan Saleh and Elif Sayeed Yaqoud played pivotal roles as the main developers for the Android app. Their contributions focused on designing a visually appealing and highly functional user interface. They created key features such as the car console, sign-up page, and login pages for users and traffic administrators, enhancing the overall user experience.
- Yingchao Ji, Jessie Johnsson, and Tehreen Asif took charge of the Arduino code development and MQTT connection. Each member actively participated in writing the Arduino code, ensuring the proper functioning and integration of different components. Their collective efforts resulted in a robust system that seamlessly combined the Arduino-based functionalities with the project infrastructure.
- Furthermore, the entire team actively contributed to the documentation process. They documented their code, processes, and project findings, ensuring that valuable insights and instructions were available for future reference. This comprehensive documentation not only served as a knowledge base but also facilitated effective collaboration within the team.


- **Project members**
- Yingchao Ji                      <gusjiyid@student.gu.se>
- Hassan Saleh                     <gussalhaf@student.gu.se>
- Jessie Johnsson                  <gusjohjefh@student.gu.se>
- Tehreen Asif                     <gusasite@student.gu.se>
- Elif Sayeed Yaqoud               <gussayel@student.gu.se>

## License
This system is complex when it comes to the traffic lights and the driving assistance system, by making minor changes, it could affect the outcome of the whole idea. As of now, there is no license to this project.

## Project status
- The project has reached its completion, with all developers working diligently and efficiently to deliver the system.