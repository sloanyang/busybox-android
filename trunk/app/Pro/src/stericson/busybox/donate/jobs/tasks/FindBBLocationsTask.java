package stericson.busybox.donate.jobs.tasks;

import android.content.Context;

import com.stericson.RootTools.RootTools;

import stericson.busybox.donate.R;
import stericson.busybox.donate.Support.Common;
import stericson.busybox.donate.jobs.AsyncJob;
import stericson.busybox.donate.jobs.containers.JobResult;

public class FindBBLocationsTask {

    public static JobResult execute(AsyncJob j, boolean single) {
        Context context = j.getContext();
        JobResult result = new JobResult();

        try {
            RootTools.getShell(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setError(context.getString(R.string.shell_error));
            return result;
        }

        result.setLocations(Common.findBusyBoxLocations(false, single));

        result.setSuccess(true);
        return result;

    }
}
