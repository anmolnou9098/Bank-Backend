package com.example.BankBackend.Service.Casher;
import com.example.BankBackend.Service.Mail.SimpleMailer;
import org.springframework.data.domain.Pageable;
import com.example.BankBackend.Model.BankadminModel;
import com.example.BankBackend.Repository.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CasherImp implements CasherService {

    @Autowired
    private SimpleMailer sm;

    @Autowired
    private adminRepository adminrepo;

    @Override
    public String transfer(Long id1, Long id2, int amount) {
        Optional<BankadminModel> acc1 = adminrepo.findById(id1);
        Optional<BankadminModel> acc2 = adminrepo.findById(id2);

        if (acc1.isEmpty() || acc2.isEmpty()) {
            return "One or both accounts not found";
        }

        BankadminModel sender = acc1.get();
        BankadminModel receiver = acc2.get();

        if (sender.getCashDeposited() < amount) {
            return "Insufficient balance in sender's account";
        }

        sender.setCashDeposited(sender.getCashDeposited() - amount);
        receiver.setCashDeposited(receiver.getCashDeposited() + amount);


        adminrepo.save(sender);
        adminrepo.save(receiver);
        sm.sendMail(receiver.getEmail(),"Money Transfer Successfully",
        "Successfully transferred "+amount+ "from Account ID "+sender.getId() +"to Account ID "+receiver.getId());

        return String.format(
                "Successfully transferred ₹%d from Account ID %d to Account ID %d",
                amount, id1, id2
        );
    }


    @Override
    public List<BankadminModel> getDetails(Pageable pg) {
        return adminrepo.getLastTransaction(pg);
    }


}
