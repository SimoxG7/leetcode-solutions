import java.util.HashSet;
import java.util.Set;

class Solution {
  public int singleNumber(int[] nums) {
    //XOR: if same, will be 0, since all are equal but one, only one will remain!
    int xor = 0;
    for (int i = 0; i < nums.length; i++) {
      xor ^= nums[i];
    }
    return xor;
  }
}



//works, but not O(1) space
class Solution2 {
  public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        set.remove(nums[i]);
      } else set.add(nums[i]);
    }
    return set.iterator().next();
  }
}

--select 
--  t.categoria, 
--  round(avg(t.probabilita), 3) as probabilita_media,
--  count(*) as tot_trans,
--  (
--    select count(*)
--    from AISSCORE.AEU_UNCLASSIFICABLE u1
--    where u1.id_transazione in (
--      select t1.id_transazione
--      from AISSCORE.AEU_TRANSACTION_MODEL_CATEGORY t1
--    )
--    and u1.cat_possibile = t.categoria
--  ) as trans_from_cestino,
--  (
--  count(*) -  
--    (select count(*)
--      from AISSCORE.AEU_UNCLASSIFICABLE u1
--      where u1.id_transazione in (
--        select t1.id_transazione
--        from AISSCORE.AEU_TRANSACTION_MODEL_CATEGORY t1
--      )
--    )
--  ) as trans_non_cestino
--from AISSCORE.AEU_TRANSACTION_MODEL_CATEGORY t
--where t.categoria is not null
--group by t.categoria
--order by t.categoria
--;