package io.mart.steps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneralHookExecutor {

    private static String currentHookFlag;

    public static void updateHookFlagValue(String newFlagValue) {
        currentHookFlag = newFlagValue;
    }

    public static boolean isSameHook(String hookFlag) {
        return hookFlag.equalsIgnoreCase(currentHookFlag);
    }

    public static void runBasedOnFlag(String hookFlag, Runnable function) {
        if (!isSameHook(hookFlag)) {
            updateHookFlagValue(hookFlag);
            function.run();
        }
    }
}