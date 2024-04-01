package edu.cnm.deepdive.leavemealone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.material.color.MaterialColors;
import edu.cnm.deepdive.leavemealone.R;
import edu.cnm.deepdive.leavemealone.databinding.ItemLocationResultsBinding;
import edu.cnm.deepdive.leavemealone.model.entity.Location;
import java.util.List;

public class LocationsAdapter extends Adapter<ViewHolder> {

  private final LayoutInflater inflater;
  private final String coordinateFormat;
  private final List<Location> locations;
  @ColorInt
  private final int secureRowBackground;
  @ColorInt
  private final int unsecureRowBackground;

  public LocationsAdapter(Context context, List<Location> locations) {
    this.locations = locations;
    inflater = LayoutInflater.from(context);
    coordinateFormat = context.getString(R.string.coordinate_format);
    secureRowBackground = MaterialColors.getColor(context, R.attr.secureRowBackground, 0);
    unsecureRowBackground = MaterialColors.getColor(context, R.attr.unsecureRowBackground, 0);
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
    return new Holder(
        ItemLocationResultsBinding.inflate(inflater, viewGroup, false),
        coordinateFormat, secureRowBackground, unsecureRowBackground);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    ((Holder) holder).bind(position, locations.get(position));
  }

  @Override
  public int getItemCount() {
    return locations.size();
  }

  private static class Holder extends RecyclerView.ViewHolder {

    private final ItemLocationResultsBinding binding;
    private final String coordinateFormat;
    @ColorInt
    private final int secureRowBackground;
    @ColorInt
    private final int unsecureRowBackground;

    Holder(ItemLocationResultsBinding binding, String coordinateFormat,
        int secureRowBackground, int unsecureRowBackground) {
      super(binding.getRoot());
      this.binding = binding;
      this.coordinateFormat = coordinateFormat;
      this.secureRowBackground = secureRowBackground;
      this.unsecureRowBackground = unsecureRowBackground;
    }

    public void bind(int position, Location location) {
      binding.getRoot().setBackgroundColor((location.isSecure()) ? secureRowBackground : unsecureRowBackground);
      binding.latitude.setText(String.format(coordinateFormat, location.getGpsCoord().latitude()));
      binding.longitude.setText(String.format(coordinateFormat, location.getGpsCoord().longitude()));
      binding.isSecure.setText(String.valueOf(location.isSecure()));
    }
  }

}
