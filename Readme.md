<h3 align="center">Appium Testing</h3>

  <p align="center">
A first mini-project developed after the training on mobile testing automation in the Zenity Academy.
</p>
    <br />
    <a href="https://github.com/benmesswass/Appium-demo-Zenity.git"><strong>gitHub Link »</strong></a>
    <br />
    <br />

   </p>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This is project for doing web automation testing with Selenium webDriver. This project tests some of the functionalities of the Airbnb Website.
<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* [java 8](https://www.oracle.com/java/technologies/java8.html)
* [Appium 1.22.2](https://appium.io/downloads.html )
* [TestNG](https://testng.org/doc/)
* [cucumber](https://cucumber.io/docs/guides/browser-automation/)
* [Maven](https://maven.apache.org/download.cgi)
* [Allure reports](https://docs.qameta.io/allure/)



<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

The tests are run on Android Emulator on the the testing app provided by Zenity.
The results are displayed in allure report format.


### Prerequisites
In order to run our program, you should respect the following prerequisites.
* Java 8 or above installed
```sh
  java -version
  ```
* Maven installed
 ```sh
  mvn -v
  ```
* Chrome and Firefox are installed in your machine and chromedriver is in PATH.


### Installation
1. [java installation guide link](https://www.google.com/search?q=java+installation&rlz=1C1CHZN_frFR980FR980&oq=java+installation&aqs=chrome..69i57.3287j0j1&sourceid=chrome&ie=UTF-8)
2. [Maven installation guide link](https://www.google.com/search?q=maven+install+windows&rlz=1C1CHZN_frFR980FR980&oq=maven+install+windows&aqs=chrome..69i57j0i13i30j0i10i22i30j0i22i30j0i8i13i30j0i8i10i13i30.4671j0j1&sourceid=chrome&ie=UTF-8)


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

1. Get access to the project  [Appium-test-Zenity](https://github.com/benmesswass/Appium-demo-Zenity.git)
2. Clone the repo
   ```sh
   git clone https://github.com/benmesswass/Appium-demo-Zenity.git
   ```
3. Run the Emulator
   ```sh
   cd C:\Users\PC77_Zenity\AppData\Local\Local\Android\Sdk\emulator
   emulator -avd Pixel4
   for headless mode: 
   emulator -avd Pixel4 -no-window
   ```

4. Run the project using Maven 
   1. Run all tests:
      registration -> disconnection -> login -> passOrder
   ```sh
      mvn clean test -Dcucumber.filter.tags='@non-reg'
   ```
   
   2. Run Scenario 1: 
   registration -> disconnection -> login -> passOrder
   ```sh
   mvn clean test -Dcucumber.filter.tags="@Scenario1"
   ```
   3. Run Scenario 2:
      login -> disconnection
   ```sh
   mvn clean test -Dcucumber.filter.tags="@Scenario2"
   ```
   
6. Check the results using allure report
    * Open cmd
    * cd ProjectPath
    * Launch the results report using the following command:
```sh
   allure serve target/allure-results
   ```

* "configuration.properties file":  to choose the device
* "application.properties":  to change the application environments


* PS: to find elements using Appium
   ```sh
   go to C:\Users\PC77_Zenity\AppData\Local\Local\Android\Sdk\tools\bin
  
   launch uiautomatorviewer  
   ```

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [] Feature 1
- [] Feature 2
- [] Feature 3
- [] Nested Feature

See the [open issues](https://github.com/github_username/repo_name/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Wassim BEN MESSAOUD - [Linkedin Profile](https://www.linkedin.com/in/wassimbenmessaoud/) - benmesswass@gmail.com

Project Link: [https://github.com/benmesswass/Appium-demo-Zenity.git](https://github.com/benmesswass/Appium-demo-Zenity.git)

<p align="right">(<a href="#top">back to top</a>)</p>



<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo_name.svg?style=for-the-badge
[contributors-url]: https://github.com/github_username/repo_name/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/github_username/repo_name.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo_name/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo_name.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo_name/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo_name.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo_name/issues
[license-shield]: https://img.shields.io/github/license/github_username/repo_name.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo_name/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png


