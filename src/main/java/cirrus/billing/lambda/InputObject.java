package cirrus.billing.lambda;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class InputObject {
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
