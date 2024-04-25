CAS PROJECT (GLOBAL IT)
TEAM 04
1.Bindu Karempudi(2327132)
2.Anand Kumbar(2327185)
3.Bandreddi Naga Mani(2327274)
4.Motupalli Shashidhar (2327325)
5.Ahmed Shaik(2327164)
6.Kamuni Meenakshi(2327130)

GLOBAL IT
----------
Problem Statement: Global IT
->Validate IT News and Awards details from Global IT
->Get profile details and validate from be cognizant.
->Validate IT app availability under Corporate Functions menu.
->Validate Other app’s availability in Global IT Home Page.
->Validate IT News and IT Awards sections availability.
->Validate all details of IT News and IT Awards.
->Print all Awards information

Key Automation Scope:
====================
->Handling alert, different browser windows, search option.
->Navigating back to home page.
->Extract multiple options items & store in collections.
->Capture warning message.
->Data Driven approach.
->Cross Browser Testing.

The Tools and Technology
========================
TestNG
Selenium
Maven 
Apache poi[MS Excel]
ExtendReports

Solution Steps for the Problem Statement
==================================
->Launch the browser(chrome/edge).
->Navigate to the Be.Cognizant Page.
->Click on the User information.
->Capture the User name and the Email.
->Click on the Corporate Functions.
->Mousehover on Security&Technology.
->Click on IT.
->Explore other apps in global IT page.
->Validate other apps in global IT page.
->Check IT News and IT Awards availability.
->Print the count of IT News and Validate the Heading and ToolTip of each IT News are same.
->Click on each IT Award and Print the description.
->Close the Website.

Output[Chrome and Edge]:
======
[RemoteTestNG] detected TestNG version 7.9.0
Chrome browser opened with the provided url
Report object Initialised
Ahmed, Shaik (Contractor)
2327164@cognizant.com
Report for clicking corporate functions and IT is generated
Report for exploring other apps in Global IT page  is generated
Report for validating IT Outage Alerts app in Global IT page is generated
Report for validating Microsoft Teams app in Global IT page is generated
Report for validating One Drive app in Global IT page is generated
Report for validating Global IT Internal Events app in Global IT page is generated
Report for validating S&T Policy Hub app in Global IT page is generated
Report for IT News availability section is generated
Report for IT Awards availability section is generated
News headers count is 12
Report for validate news header and tooltip is generated
Congratulations to Rishabh Raj, Sr. Business Analyst, from the IT Resilience Office for successfully completing an external certification - EC Council Disaster Recovery Professional (EDRP). The achievement has equipped him with extensive knowledge on the effective strategies for data backup, system redundancy, availability, and incident response. This would help the concerned team in effectively dealing with potential disasters and ensuring continuity to the critical IT applications.
Report for award 1 description is generated
Congratulations to the IT team for winning the “DevSecOps Cultural Transformation Award” and the “Best Value Stream Management (VSM) Implementation Project” award at the prestigious DevOps India Summit 2023, organized by Xellentro.com.The honor was awarded for the best implementation of DevSecOps within IT, which transformed and optimized delivery excellence, customer satisfaction, and operational effectiveness. 
Report for award 2 description is generated
Cognizant Analytical Marketplace aka CInsights, the home-grown innovative cloud-based analytical solution, has received the esteemed Brandon Hall Group Bronze award for the best advancement in business strategy and technology innovation.CInsights revolutionizes the process of discovering valuable information and insights by empowering both organizations and customers to effortlessly generate analytical reports and dashboards. It transforms data discovery and utilization through its unified digital experience.One of the differentiating features of CInsights is its unique Role Hierarchy Management System (RHMS), ensuring effective data protection, and streamlined workflows. This innovative solution not only provides a secure and centralized platform for organizations to access their reports, dashboards, metrics, and insights, but also facilitates seamless collaboration, while ensuring that analytical assets are up to date and readily accessible. Read more about CInsights on Video - CInsights | Cognizant Academy (kpoint.com).
Report for award 3 description is generated
Closed the browser
 
Apr 02, 2024 6:02:27 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 123, returning the closest version; found: 122; Please update to a Selenium version that supports CDP version 123
 
Edge browser opened with the provided url
Report object Initialised
Ahmed, Shaik (Contractor)
2327164@cognizant.com
Report for clicking corporate functions and IT is generated
Report for exploring other apps in Global IT page  is generated
Report for validating IT Outage Alerts app in Global IT page is generated
Report for validating Microsoft Teams app in Global IT page is generated
Report for validating One Drive app in Global IT page is generated
Report for validating Global IT Internal Events app in Global IT page is generated
Report for validating S&T Policy Hub app in Global IT page is generated
Report for IT News availability section is generated
Report for IT Awards availability section is generated
News headers count is 12
Report for validate news header and tooltip is generated
Congratulations to Rishabh Raj, Sr. Business Analyst, from the IT Resilience Office for successfully completing an external certification - EC Council Disaster Recovery Professional (EDRP). The achievement has equipped him with extensive knowledge on the effective strategies for data backup, system redundancy, availability, and incident response. This would help the concerned team in effectively dealing with potential disasters and ensuring continuity to the critical IT applications.
Report for award 1 description is generated
Congratulations to the IT team for winning the “DevSecOps Cultural Transformation Award” and the “Best Value Stream Management (VSM) Implementation Project” award at the prestigious DevOps India Summit 2023, organized by Xellentro.com.The honor was awarded for the best implementation of DevSecOps within IT, which transformed and optimized delivery excellence, customer satisfaction, and operational effectiveness. 
Report for award 2 description is generated
Cognizant Analytical Marketplace aka CInsights, the home-grown innovative cloud-based analytical solution, has received the esteemed Brandon Hall Group Bronze award for the best advancement in business strategy and technology innovation.CInsights revolutionizes the process of discovering valuable information and insights by empowering both organizations and customers to effortlessly generate analytical reports and dashboards. It transforms data discovery and utilization through its unified digital experience.One of the differentiating features of CInsights is its unique Role Hierarchy Management System (RHMS), ensuring effective data protection, and streamlined workflows. This innovative solution not only provides a secure and centralized platform for organizations to access their reports, dashboards, metrics, and insights, but also facilitates seamless collaboration, while ensuring that analytical assets are up to date and readily accessible. Read more about CInsights on Video - CInsights | Cognizant Academy (kpoint.com).
Report for award 3 description is generated
Closed the browser
 
===============================================
Suite
Total tests run: 30, Passes: 30, Failures: 0, Skips: 0
===============================================
 

Added dependencies:
==================
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
	<dependency>
		<groupId>org.seleniumhq.selenium</groupId>
		<artifactId>selenium-java</artifactId>
		<version>4.18.1</version>
	</dependency>
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
	<dependency>
		<groupId>org.testng</groupId>
		<artifactId>testng</artifactId>
		<version>7.9.0</version>
		<scope>test</scope>
	</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
<dependency>
	<groupId>org.apache.poi</groupId>
	<artifactId>poi</artifactId>
	<version>5.2.5</version>
</dependency>
<!--  https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml  -->
<dependency>
	<groupId>org.apache.poi</groupId>
	<artifactId>poi-ooxml</artifactId>
	<version>5.2.5</version>
</dependency>
<!--  https://mvnrepository.com/artifact/com.aventstack/extentreports  -->
<dependency>
	<groupId>com.aventstack</groupId>
	<artifactId>extentreports</artifactId>
	<version>5.1.1</version>
</dependency>
<!--  https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-slf4j-impl  -->
<dependency>
	<groupId>org.apache.logging.log4j</groupId>
	<artifactId>log4j-slf4j-impl</artifactId>
	<version>2.22.0</version>
</dependency>
<!--  https://mvnrepository.com/artifact/commons-io/commons-io  -->
<dependency>
	<groupId>commons-io</groupId>
	<artifactId>commons-io</artifactId>
	<version>2.15.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
<dependency>
	<groupId>org.apache.logging.log4j</groupId>
	<artifactId>log4j-core</artifactId>
	<version>2.23.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
<dependency>
	<groupId>org.apache.logging.log4j</groupId>
	<artifactId>log4j-api</artifactId>
	<version>2.23.1</version>
</dependency>
has context menu