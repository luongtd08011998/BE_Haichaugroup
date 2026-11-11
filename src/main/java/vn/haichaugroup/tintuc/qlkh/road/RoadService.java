package vn.haichaugroup.tintuc.qlkh.road;
import vn.haichaugroup.tintuc.qlkh.road.dto.RoadDropdownResponse;
import java.util.List;
public interface RoadService {
    List<RoadDropdownResponse> getAllRoadsForDropdown();
}
