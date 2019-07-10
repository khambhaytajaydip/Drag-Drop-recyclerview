import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_edit_profile.*

/**
 * Created by JAI on 10,July,2019
 */

class DropDownRecyclerView : AppCompatActivity(){
    lateinit var rvAddPhotos: RecyclerView
    lateinit var listImages: MutableList<ProfileImage>
    lateinit var addImageSelectionAdapter: AddImageSelectionAdapter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_drop_down_recyler)
        rvAddPhotos = findViewById(R.id.rvProfilePhotos)

        listImages = getSwipeProfileImage(applicationContext)
        addImageSelectionAdapter = AddImageSelectionAdapter(listImages)
        rvProfilePhotos.layoutManager = LinearLayoutManager(this)
        rvProfilePhotos.adapter = addImageSelectionAdapter
        rvProfilePhotos.isFocusableInTouchMode = true
        val callback = DragManageAdapter(
            addImageSelectionAdapter, this,
            ItemTouchHelper.UP.or(ItemTouchHelper.DOWN), ItemTouchHelper.UP.or(ItemTouchHelper.DOWN)
        )
        val helper = ItemTouchHelper(callback)
        helper.attachToRecyclerView(rvProfilePhotos)


    }
    fun getSwipeProfileImage(context: Context): MutableList<ProfileImage> {
        val bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_add_image)

        val arrayOfInterest = mutableListOf<ProfileImage>()
        arrayOfInterest.add(ProfileImage("A", bm, false, "https://homepages.cae.wisc.edu/~ece533/images/boy.bmp"))
        arrayOfInterest.add(ProfileImage("B", bm, false, "https://homepages.cae.wisc.edu/~ece533/images/sails.png"))
        arrayOfInterest.add(ProfileImage("C", bm, false, "https://homepages.cae.wisc.edu/~ece533/images/fruits.png"))
        arrayOfInterest.add(ProfileImage("D", bm, false, "https://homepages.cae.wisc.edu/~ece533/images/girl.png"))
        arrayOfInterest.add(ProfileImage("E", bm, false, "https://homepages.cae.wisc.edu/~ece533/images/pool.png"))

        return arrayOfInterest

    }






}