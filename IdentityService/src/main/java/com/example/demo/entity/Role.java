package com.example.demo.entity;

public enum Role {
	PHARMACIST, //Manages stock, dispenses medications, quarantines expired/near-expiry batches
	PROCUREMENT_OFFICER, //Creates purchase orders, receives deliveries, and reconciles invoices
	STOREKEEPER, //Performs stock counts, updates receipts, and moves stock between locations
	CLINICIAN, //Views medication availability and requests urgent supplies
	COMPLIANCE_OFFICER, //Reviews expiry reports, recall evidence, and audit logs
	ADMINISTRATOR,//Configures products, locations, roles, and system settings
	AUDITOR //Reviews immutable transaction trails and compliance reports
}