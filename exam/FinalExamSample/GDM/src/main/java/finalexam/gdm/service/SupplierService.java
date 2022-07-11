package finalexam.gdm.service;

import finalexam.gdm.model.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> getAllSuppliers();
    Supplier addNewSupplier(Supplier supplier);


}

