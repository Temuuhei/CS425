package finalexam.gdm.service.impl;


import finalexam.gdm.model.Supplier;
import finalexam.gdm.service.SupplierService;
import finalexam.gdm.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl  implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier addNewSupplier(Supplier supplier) {
        var newSupplier = supplierRepository.save(supplier);
        return newSupplier;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        var suppliers = supplierRepository.findAll();
        return suppliers;
    }
}
