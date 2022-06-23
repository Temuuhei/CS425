/**
 * productDAO.js
 */
"use strict";

const dbConectionMgr = require("../dbconnectionmgr");
const dbConnectionMgr = require("../dbconnectionmgr");

//TODO Use ES6 class syntax
const patientDAO = (function() {

    // const getProducts = function() {
    //     const products = [];
    //     products.push(new Product(1001, "Apple iPhone15", 1700));
    //     products.push(new Product(1002, "Samsung Android S22", 1500));
    //     products.push(new Product(1001, "Google Pixel 11", 1200));
    //     return products;
    // }

    /**
     * Fetches and returns all available products in the database
     */
    const getPatients = async function() {
        const qryStrGetPatients = "SELECT * FROM `patientsdb`.patients ORDER BY fullName ASC";
        try {
            const dbConnection = dbConnectionMgr.getConnection();
            const [patients] = await dbConnection.promise().query(qryStrGetPatients);
            return patients;
        } catch (error) {
            console.log(`DB Access Error: ${error}`);
            throw error;
        }
    };

    const getElderlyPatients = async function() {
        const qryStrGetPatients = "SELECT * FROM `patientsdb`.patients WHERE dateOfBirth <= '2020-01-01' ORDER BY fullName ASC";
        try {
            const dbConnection = dbConnectionMgr.getConnection();
            const [patients] = await dbConnection.promise().query(qryStrGetPatients);
            return patients;
        } catch (error) {
            console.log(`DB Access Error: ${error}`);
            throw error;
        }
    };
    let pId =7;
    const savePatient = async function(patient) {
        const cmdStrSavePatient = `INSERT INTO patients
                (
                patientIdNumber,
                fullName,
                emailAddress,
                contactPhoneNumber,
                dateOfBirth,
                ddlDepartment,
                isAnOutPatient)
        VALUES
                (
                '${patient.patientIdNumber}',
                '${patient.fullName}',
                '${patient.emailAddress}',
                '${patient.contactPhoneNumber}',
                '${patient.dateOfBirth}',
                '${patient.ddlDepartment}',
                '${patient.isAnOutPatient}');
        `;
        try {
            const dbConnection = dbConectionMgr.getConnection();
            const saveOpResult = await dbConnection.promise().execute(cmdStrSavePatient);
            return saveOpResult;
        } catch(error) {
            console.log(`DB Access Error: ${error}`);
            throw error;
        }
    }

    return {
        getPatients: getPatients,
        savePatient: savePatient,
        getElderlyPatients: getElderlyPatients
    }
})();

module.exports = patientDAO;