--  Spawacze
insert into WELDERS (certificateNo, firstName, lastName, maxDiameter, maxWallThickness, minDiameter, minWallThickness, welderNo) values ("CertNo1", "Adam", "Adamowicz", 500, 20, 15, 1, "E01");
insert into WELDERS (certificateNo, firstName, lastName, maxDiameter, maxWallThickness, minDiameter, minWallThickness, welderNo) values ("CertNo1", "Adam", "Grabowski", 380, 15, 21, 2, "E02");
insert into WELDERS (certificateNo, firstName, lastName, maxDiameter, maxWallThickness, minDiameter, minWallThickness, welderNo) values ("CertNo1", "Pawel", "Bogusz", 500, 20, 15, 1, "E03");



--  WPSy
insert into WPS (wpsNumber, fillerMaterial, material, materialGr, maxDiameter, maxWallThickness, minDiameter, minWallThickness, weldType, weldingType) values ("WPSno1", "FillMat1", "1.4307", "8.1", 500, 20, 15, 1, "BW", "141");
insert into WPS (wpsNumber, fillerMaterial, material, materialGr, maxDiameter, maxWallThickness, minDiameter, minWallThickness, weldType, weldingType) values ("WPSno2", "FillMat1", "1.4307", "8.1", 200, 5, 120, 3, "BW", "141");
insert into WPS (wpsNumber, fillerMaterial, material, materialGr, maxDiameter, maxWallThickness, minDiameter, minWallThickness, weldType, weldingType) values ("WPSno3", "FillMat2", "1.4462", "10.1", 200, 5, 120, 3, "BW", "141");


-- Systemy
insert into SYSTEMS (VTPercentage, name, ptPercentage, rtPercentage) values (1.0, "MainSteam", 0.1, 0.2)
insert into SYSTEMS (VTPercentage, name, ptPercentage, rtPercentage) values (1.0, "FeedWater", 0.1, 0.05)

-- Rysunki
insert into DRAWINGS (dwgNumber, system_id) values ("DWG0001", 2);
insert into DRAWINGS (dwgNumber, system_id) values ("DWG0002", 2);
insert into DRAWINGS (dwgNumber, system_id) values ("DWG0003", 2);