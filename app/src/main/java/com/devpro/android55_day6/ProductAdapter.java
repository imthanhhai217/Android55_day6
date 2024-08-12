package com.devpro.android55_day6;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.devpro.android55_day6.interfaces.IOnProductClickListener;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<ProductModel> mListData;
    private Context mContext;
    private IOnProductClickListener clickListener;

    public ProductAdapter(ArrayList<ProductModel> listData,IOnProductClickListener clickListener ) {
        this.mListData = listData;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        Log.d("TAG", "onCreateViewHolder: ");
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        ProductModel productModel = mListData.get(position);
        Log.d("TAG", "onBindViewHolder: "+position);
        holder.tvProductName.setText(productModel.getProductName());
        holder.tvProductPrice.setText(productModel.getProductPrice() + "$");
        holder.tvColor.setText(productModel.getProductColor());
        holder.tvSize.setText(productModel.getProductSize());
        Glide.with(mContext).load(productModel.getProductImage()).placeholder(R.mipmap.ic_launcher).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgProduct, imgRemove, imgAddToCart;
        TextView tvProductName, tvProductPrice, tvSize, tvColor;
        ConstraintLayout clProduct;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            clProduct = itemView.findViewById(R.id.clProduct);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            imgRemove = itemView.findViewById(R.id.imgRemove);
            imgAddToCart = itemView.findViewById(R.id.imgAddToCart);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            tvSize = itemView.findViewById(R.id.tvSize);
            tvColor = itemView.findViewById(R.id.tvColor);

            imgAddToCart.setOnClickListener(this);
            imgRemove.setOnClickListener(this);
            clProduct.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.clProduct) {
                clickListener.onProductClickListener(getAdapterPosition());
            }
            if (v.getId() == R.id.imgAddToCart) {
                clickListener.onAddProductToCart(getAdapterPosition());
            }
            if (v.getId() == R.id.imgRemove) {
                clickListener.onRemoveProduct(getAdapterPosition());
            }
        }
    }
}
