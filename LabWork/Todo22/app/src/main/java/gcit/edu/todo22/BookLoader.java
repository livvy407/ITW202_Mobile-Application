package gcit.edu.todo22;

import android.content.AsyncTaskLoader;

public class BookLoader extends AsyncTaskLoader<String> {

    private String mQueryString;


    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }

    @Override
    protected void onStartLoading(){

        super.onStartLoading();
        forceLoad();
    }
}
