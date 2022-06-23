package Observer;


import java.util.List;

public interface DAOObserver {
	 void onRegister();
	 void onDDL();
	 <T> void onQuery(List<T> list);
	 void onUpdate();
}
