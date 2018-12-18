# ambit-knime
This repository contains a set of KNIME nodes for Ambit.  
Download appropriate KNIME node JAR file from the release section (e.g. net.idea.ambit.knime.query_1.0.0.jar) and placed it in KNIME Analytics Platform installation in dropins folder (``...\KNIME\dropins``).    
Example KNIME workflows that demonstrate the Ambit nodes usage can be found in folder [demo-workflows](https://github.com/ideaconsult/ambit-knime/tree/master/demo-workflows). 

***

**Tips for KNIME node developers:** 
- Setup KNIME-SDK in Eclipse RCP following the steps described in <https://github.com/knime/knime-sdk-setup>
- Each folder in this repository (except demo-workflows) contains a RCP Eclipse project for a single KNIME node . 
- After cloning the repository, import the corresponding node folder as an Eclipse project (``File → Import → General → Projects from  Folder or Archive``)

