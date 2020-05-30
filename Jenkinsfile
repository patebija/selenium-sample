pipeline {
   agent any

   stages {
      stage('Build') {
         steps {
            git 'https://github.com/patebija/selenium-sample.git'
            bat 'mvn -B clean'
         }
      }
      stage('Test'){
          steps{
              bat 'mvn -B install'
          }
          cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
      }
      stage('Archive'){
          steps{
              archiveArtifacts 'target/*.jar'
          }
      }
   }
}
