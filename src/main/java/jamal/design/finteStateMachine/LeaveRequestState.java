package jamal.design.finteStateMachine;

public enum LeaveRequestState {
    SUBMITTED {
        @Override
        public String responsiblePerson() {
            return "Employee";
        }

        @Override
        public LeaveRequestState nextState() {
            return ESCALATED;
        }

        @Override
        public LeaveRequestState previousState() {
            return this;
        }
    },
    ESCALATED {
        @Override
        public String responsiblePerson() {
            return "Employee";
        }

        @Override
        public LeaveRequestState nextState() {
            return APPROVED;
        }

        @Override
        public LeaveRequestState previousState() {
            return SUBMITTED;
        }
    },
    APPROVED {
        @Override
        public String responsiblePerson() {
            return "Employee";
        }

        @Override
        public LeaveRequestState nextState() {
            return this;
        }

        @Override
        public LeaveRequestState previousState() {
            return ESCALATED;
        }
    };

    public abstract String responsiblePerson();

    public abstract LeaveRequestState nextState();

    public abstract LeaveRequestState previousState();
}
