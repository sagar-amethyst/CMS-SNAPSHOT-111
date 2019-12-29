
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.callippus.water.erp.domain.enumeration.EmpLeaveBalanceStatus;

/**
 * A EmpLeaveBalance.
 */
@Entity
@Table(name = "emp_leave_balance")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmpLeaveBalance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "no_of_days", nullable = false)
    private Integer noOfDays;
    
    @NotNull
    @Column(name = "used_balance", nullable = false)
    private Integer usedBalance;
    
    @NotNull
    @Column(name = "avliable_balance", nullable = false)
    private Integer avliableBalance;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "emp_leave_balance_status")
    private EmpLeaveBalanceStatus empLeaveBalanceStatus;
    
    @ManyToOne
    @JoinColumn(name = "emp_master_id")
    private EmpMaster empMaster;

    @ManyToOne
    @JoinColumn(name = "leave_types_id")
    private LeaveTypes leaveTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNoOfDays() {
        return noOfDays;
    }
    
    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }

    public EmpLeaveBalanceStatus getEmpLeaveBalanceStatus() {
        return empLeaveBalanceStatus;
    }
    
    public void setEmpLeaveBalanceStatus(EmpLeaveBalanceStatus empLeaveBalanceStatus) {
        this.empLeaveBalanceStatus = empLeaveBalanceStatus;
    }

    public EmpMaster getEmpMaster() {
        return empMaster;
    }

    public void setEmpMaster(EmpMaster empMaster) {
        this.empMaster = empMaster;
    }

    public LeaveTypes getLeaveTypes() {
        return leaveTypes;
    }

    public void setLeaveTypes(LeaveTypes leaveTypes) {
        this.leaveTypes = leaveTypes;
    }

    
    
    public Integer getUsedBalance() {
		return usedBalance;
	}

	public void setUsedBalance(Integer usedBalance) {
		this.usedBalance = usedBalance;
	}

	public Integer getAvliableBalance() {
		return avliableBalance;
	}

	public void setAvliableBalance(Integer avliableBalance) {
		this.avliableBalance = avliableBalance;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmpLeaveBalance empLeaveBalance = (EmpLeaveBalance) o;
        if(empLeaveBalance.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, empLeaveBalance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "EmpLeaveBalance{" +
            "id=" + id +
            ", noOfDays='" + noOfDays + "'" +
            ", empLeaveBalanceStatus='" + empLeaveBalanceStatus + "'" +
            '}';
    }
}
