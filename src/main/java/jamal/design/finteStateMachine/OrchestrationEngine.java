package jamal.design.finteStateMachine;

import java.util.Arrays;
import java.util.List;
enum AdvancedOutreachState {
    NEW {
        @Override
        public List<AdvancedOutreachState> nextState() {
            return Arrays.asList(PAUSE, PROCESSING, SCHEDULED);
        }

        @Override
        public List<AdvancedOutreachState> previousState() {
            return Arrays.asList(this);
        }
    },
    SCHEDULED {
        @Override
        public List<AdvancedOutreachState> nextState() {
            return Arrays.asList(PROCESSING, PAUSE);
        }

        @Override
        public List<AdvancedOutreachState> previousState() {
            return Arrays.asList(NEW);
        }
    },
    PROCESSING {
        @Override
        public List<AdvancedOutreachState> nextState() {
            return Arrays.asList(PAUSE, STOP, COMPLETED, STOP_PARTICIPANT_ADDITION);
        }

        @Override
        public List<AdvancedOutreachState> previousState() {
            return Arrays.asList(NEW, SCHEDULED);
        }
    },
    PAUSE {
        @Override
        public List<AdvancedOutreachState> nextState() {
            return Arrays.asList(STOP, STOP_PARTICIPANT_ADDITION);
        }

        @Override
        public List<AdvancedOutreachState> previousState() {
            return Arrays.asList(PROCESSING);
        }
    },
    COMPLETED {
        @Override
        public List<AdvancedOutreachState> nextState() {
            return Arrays.asList(this);
        }

        @Override
        public List<AdvancedOutreachState> previousState() {
            return Arrays.asList(PROCESSING);
        }
    },
    STOP {
        @Override
        public List<AdvancedOutreachState> nextState() {
            return Arrays.asList(this);
        }

        @Override
        public List<AdvancedOutreachState> previousState() {
            return Arrays.asList(PAUSE, PROCESSING);
        }
    },
    STOP_PARTICIPANT_ADDITION {
        @Override
        public List<AdvancedOutreachState> nextState() {
            return Arrays.asList(this);
        }

        @Override
        public List<AdvancedOutreachState> previousState() {
            return Arrays.asList(PROCESSING, PAUSE);
        }
    };

    public abstract List<AdvancedOutreachState> nextState();

    public abstract List<AdvancedOutreachState> previousState();

}

enum ParticipantState {

    REVIEW {
        @Override
        public List<ParticipantState> nextState() {
            System.out.println("I am at REVIEW state");
            return Arrays.asList(NEW);
        }

        @Override
        public List<ParticipantState> previousState() {

            return Arrays.asList(this);
        }
    },
    NEW {
        @Override
        public List<ParticipantState> nextState() {
            System.out.println("I am at NEW state");
            return Arrays.asList(ACTIVE, KNOCKED_OFF, SYSTEM_ERROR);
        }

        @Override
        public List<ParticipantState> previousState() {

            return Arrays.asList(REVIEW);
        }
    },
    ACTIVE {
        @Override
        public List<ParticipantState> nextState() {
            System.out.println("I am at ACTIVE state");
            return Arrays.asList(COMPLETED, PAUSED, KNOCKED_OFF, SYSTEM_ERROR);
        }

        @Override
        public List<ParticipantState> previousState() {

            return Arrays.asList(NEW);
        }
    },
    PAUSED {
        @Override
        public List<ParticipantState> nextState() {
            System.out.println("I am at PAUSED state");
            return Arrays.asList(KNOCKED_OFF, DROP);
        }

        @Override
        public List<ParticipantState> previousState() {

            return Arrays.asList(ACTIVE);
        }
    },
    KNOCKED_OFF {
        @Override
        public List<ParticipantState> nextState() {
            System.out.println("I am at KNOCKED_OFF state");
            return Arrays.asList(this);
        }

        @Override
        public List<ParticipantState> previousState() {

            return Arrays.asList(PAUSED, ACTIVE);
        }
    },
    COMPLETED {
        @Override
        public List<ParticipantState> nextState() {
            System.out.println("I am at COMPLETED state");
            return Arrays.asList(this);
        }

        @Override
        public List<ParticipantState> previousState() {

            return Arrays.asList(ACTIVE);
        }
    },
    SYSTEM_ERROR {
        @Override
        public List<ParticipantState> nextState() {
            System.out.println("I am at SYSTEM_ERROR state");
            return Arrays.asList(this);
        }

        @Override
        public List<ParticipantState> previousState() {

            return Arrays.asList(ACTIVE);
        }
    },
    DROP {
        @Override
        public List<ParticipantState> nextState() {
            System.out.println("I am at DROP state");
            return Arrays.asList(this);
        }

        @Override
        public List<ParticipantState> previousState() {

            return Arrays.asList(ACTIVE);
        }
    };

    public abstract List<ParticipantState> nextState();

    public abstract List<ParticipantState> previousState();

}

public class OrchestrationEngine {
    public static void main(String[] args) {
        OrchestrationEngine orchestrationEngine = new OrchestrationEngine();
        orchestrationEngine.demoNormalParticipant();
    }

    private void demoNormalParticipant() {
        ParticipantState participantState = ParticipantState.REVIEW.nextState().get(0).nextState().get(0).nextState().get(0).nextState().get(0);
        System.out.println("The final state of the machine " + participantState);
    }

}
