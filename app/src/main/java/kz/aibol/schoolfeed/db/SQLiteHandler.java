package kz.aibol.schoolfeed.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import kz.aibol.schoolfeed.helper.Post;

/**
 * SchoolFeed
 * Created by Aibol Kussain on 5/27/2015.
 * For support information write kussain@aibol.kz
 */
public class SQLiteHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "schoolfeed";

    // tables
    private static final String TABLE_POSTS = "posts";

    // posts table columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DATE = "date";
    private static final String KEY_CONTENT = "content";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POSTS_TABLE = "CREATE TABLE " + TABLE_POSTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT, "
                + KEY_DATE + " TEXT," + KEY_CONTENT + " TEXT" + ")";
        db.execSQL(CREATE_POSTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POSTS);
        onCreate(db);
    }

    public void addPost(String name, String date, String content) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_DATE, date);
        values.put(KEY_CONTENT, content);

        long id = db.insert(TABLE_POSTS, null, values);
        db.close();
    }

    public ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_POSTS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            Post post = new Post(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            posts.add(post);
        }
        cursor.close();
        db.close();

        return posts;
    }
}
