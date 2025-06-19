package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Pago;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PagoRepository {
    private final List<Pago> pagos = new ArrayList<>();
    public List<Pago> findAll() { return pagos; }
    public Optional<Pago> findById(Long id) {
        return pagos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    public Pago save(Pago pago) {
        pagos.add(pago);
        return pago;
    }
    public Pago update(Long id, Pago pago) {
        for (int i = 0; i < pagos.size(); i++) {
            if (pagos.get(i).getId().equals(id)) {
                pagos.set(i, pago);
                return pago;
            }
        }
        return null;
    }
    public boolean delete(Long id) {
        return pagos.removeIf(p -> p.getId().equals(id));
    }
}