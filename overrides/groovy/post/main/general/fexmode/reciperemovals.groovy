package post.main.general.fexmode

//remove all converters
for (var converter_id: ['1670', '1671', '1672', '1673', '1674', '1675', '1676', '1677', '1678', '1679', '1680', '1681', '1682', '1683', '1684', '1685', '1686', '1687', '1688', '1689', '1690', '1691', '1692', '1693', '1694', '1695', '1696', '1697', '1698', '1699', '1700', '1701', '1702', '1703', '1704', '1705', '1706', '1707', '1708', '1709']) {

    var converters_all = item("gregtech:machine:${converter_id}")
    //mods.jei.ingredient.hide(metaname) comment cuz maybe i wanna add this
    crafting.removeByOutput([converters_all])
}
