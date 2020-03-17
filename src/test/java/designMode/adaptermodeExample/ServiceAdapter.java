package designMode.adaptermodeExample;

import designMode.adaptermode.Adaptee;

public class ServiceAdapter extends AbstractService {
    private Adaptee adaptee;

    public ServiceAdapter() {
        adaptee = new Adaptee();
    }

    @Override
    public void serviceMethod1() {
        adaptee.specificRequest();
    }
}
