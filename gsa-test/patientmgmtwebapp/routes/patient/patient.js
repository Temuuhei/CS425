/**
 * product.js
 */
"use strict";

const express = require("express");
const path = require("path");
const patientRouter = express.Router();
// const product = require("../../model/product");
const patientController = require("../../controller/patientController");

// Define routes for product pages
patientRouter.get("/list", async (req, res, next) => {
    console.log(`Presenting list of patients page`);
    const patients = await patientController.getPatients(req, res);
    console.log(patients);
    res.locals = {patients: patients};
    // pug file rendering
    res.render("patients");
    // res.render("product-list", {products: products});
});

patientRouter.get("/list/elderly", async (req, res, next) => {
    const patients = await patientController.getElderlyPatients(req, res);
    console.log(patients);
    res.locals = {patients: patients};
    // pug file rendering
    res.render("patients");
    // res.render("product-list", {products: products});
});

patientRouter.get("/new", (req, res, next) => {
    res.sendFile(path.join(__dirname, "../../views", "patient-form.html"));
});

patientRouter.post("/new", async (req, res, next) => {
    const result = await patientController.addNewPatient(req, res);
    res.redirect(303, "/patient/list");
});

module.exports = patientRouter;
