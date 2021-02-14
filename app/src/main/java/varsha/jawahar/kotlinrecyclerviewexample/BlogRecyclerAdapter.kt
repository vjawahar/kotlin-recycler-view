package varsha.jawahar.kotlinrecyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*
import varsha.jawahar.kotlinrecyclerviewexample.models.BlogPost

class BlogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    //ArrayList of BlogPost Objects
    private var items : List<BlogPost> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //creating the different individual ViewHolders
        return BlogViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BlogViewHolder ->{ //when ViewHolder is of type BlogViewHolder
                holder.bind(items.get(position)) //bind data to particular ViewHolder that is in view
            }
        }
    }

    fun submitList(blogList : List<BlogPost>){ //how we submit the Blog Post data list to Recycler Adapter
        items = blogList


    }


    class BlogViewHolder constructor(itemView : View): RecyclerView.ViewHolder(itemView){

        val blogImage = itemView.blog_image //blog_image is the ID of the text view from layout_blog_list_item
        val blogTitle = itemView.blog_title //associating these views to the ViewHolder class in adapter
        val blogAuthor = itemView.blog_author

        fun bind(blogPost : BlogPost){
            //takes each BlogPost object and binding it to the layout
            blogTitle.setText(blogPost.title)
            blogAuthor.setText(blogPost.username)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

                //setting default properties to Glide for image (and an error case if it cannot)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image) //image URL from gitHub
                .into(blogImage) //image view we have inside of our layout list blog item

        }


    }




}