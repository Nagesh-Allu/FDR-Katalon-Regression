<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteCollectionEntity>
   <description>TestSuite Collection</description>
   <name>TestSuite Collection</name>
   <tag></tag>
   <executionMode>SEQUENTIAL</executionMode>
   <maxConcurrentInstances>8</maxConcurrentInstances>
   <testSuiteRunConfigurations>
      <TestSuiteRunConfiguration>
         <configuration>
            <groupName>Web Desktop</groupName>
            <profileName>SysAdmin</profileName>
            <runConfigurationId>Chrome</runConfigurationId>
         </configuration>
         <runEnabled>false</runEnabled>
         <testSuiteEntity>Test Suites/SystemAdmin-Integration_Suite</testSuiteEntity>
      </TestSuiteRunConfiguration>
      <TestSuiteRunConfiguration>
         <configuration>
            <groupName>Web Desktop</groupName>
            <profileName>Voucher</profileName>
            <runConfigurationId>Chrome</runConfigurationId>
         </configuration>
         <runEnabled>true</runEnabled>
         <testSuiteEntity>Test Suites/Voucher-Integration_Suite</testSuiteEntity>
      </TestSuiteRunConfiguration>
      <TestSuiteRunConfiguration>
         <configuration>
            <groupName>Web Desktop</groupName>
            <profileName>Receipt</profileName>
            <runConfigurationId>Chrome</runConfigurationId>
         </configuration>
         <runEnabled>false</runEnabled>
         <testSuiteEntity>Test Suites/Receipt-Integration_Suite</testSuiteEntity>
      </TestSuiteRunConfiguration>
      <TestSuiteRunConfiguration>
         <configuration>
            <groupName>Web Desktop</groupName>
            <profileName>Draw</profileName>
            <runConfigurationId>Chrome</runConfigurationId>
         </configuration>
         <runEnabled>true</runEnabled>
         <testSuiteEntity>Test Suites/Draw-Integration_Suite</testSuiteEntity>
      </TestSuiteRunConfiguration>
   </testSuiteRunConfigurations>
</TestSuiteCollectionEntity>
