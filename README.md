# Forecasting Car Sales

## Overview
An advanced forecasting application that predicts product sales for the next two years using four different forecasting methodologies. By analyzing historical monthly sales data from the past two years, this tool provides accurate projections to support business planning and inventory management.

![Figure 0: Flowchart](src/main/resources/images/flowchart.jpeg)

## Features

- **Multiple Forecasting Methods**: Implements Exponential Smoothing, Double Exponential Smoothing, Regression Analysis, and Deseasonalized Regression Analysis
- **Interactive Visualization**: Graphical representation of forecasted sales data
- **Data Management**: Add, view, update, and delete datasets
- **Performance Metrics**: Compare methods using MSE (Mean Squared Error) and min/max forecasted sales
- **Persistent Storage**: MongoDB integration for reliable data management

## Technology Stack

- **Frontend**: JavaFX with FXML
- **Database**: MongoDB
- **Language**: Java

## User Interface

### Main Dashboard
The application starts with an intuitive main screen displaying your datasets. Each dataset is automatically named according to its creation date, though custom naming is available.

![Figure 1: Main Screen](src/main/resources/images/firstlook.png)

### Data Management

#### Viewing & Updating Data
Select any dataset and click the View/Update button to access detailed records and modify individual entries as needed.

![Figure 2: View Update Screen](src/main/resources/images/view.png)

#### Record Modification
Each record is contained in an editable text field, allowing for easy corrections without recreating entire datasets.

![Figure 3: Update a Record](src/main/resources/images/update.png)

Changes are automatically synchronized with the MongoDB database:

![Figure 4: Record updated in MongoDB](src/main/resources/images/updateindb.png)

#### Adding New Datasets
The Add Dataset menu provides a streamlined interface for importing new sales data.

![Figure 6: Add Dataset Menu](src/main/resources/images/addmenu.png)

Successful additions are immediately reflected in both the UI and database:

![Figure 7: After Add](src/main/resources/images/afteradd.png)

#### Removing Datasets
Delete any selected dataset with a single click, which removes it from both the UI and database.

![Figure 7: Delete a Dataset](src/main/resources/images/delete.png)

## Database Architecture

Each dataset is stored with a unique identifier and structured for optimal performance:

![Figure 5: Dataset Modeling](src/main/resources/images/datasetmodeling.png)

## Forecasting Capabilities

### Method Comparison
Select any dataset and click "Get forecast" to compare all available forecasting methods:

![Figure 8: All Forecast Methods Overview](src/main/resources/images/forecasts.png)

The system provides key metrics including minimum/maximum forecasted sales and Mean Squared Error (MSE) to help you select the most appropriate method for your data.

### Forecast Visualizations

After selecting your preferred method, view detailed month-by-month projections for the next two years:

#### Exponential Smoothing
![Figure 9: Sales According to Exponential Smoothing](src/main/resources/images/de.png)

#### Double Exponential Smoothing
![Figure 10: Sales According to Double Exponential Smoothing](src/main/resources/images/des.png)

#### Regression Analysis
![Figure 11: Sales According to Regression Analysis](src/main/resources/images/ra.png)

#### Deseasonalized Regression Analysis
![Figure 12: Sales According to Deseasonalized Regression Analysis](src/main/resources/images/dra.png)
