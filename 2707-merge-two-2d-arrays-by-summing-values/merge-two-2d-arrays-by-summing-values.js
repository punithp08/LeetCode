/**
 * @param {number[][]} nums1
 * @param {number[][]} nums2
 * @return {number[][]}
 */
var mergeArrays = function(nums1, nums2) {
    const result = [];
    let p1 = 0;
    let p2 = 0;
    const n1 = nums1.length;
    const n2 = nums2.length;

    while (p1 < n1 || p2 < n2) {
        if (p1 < n1 && p2 < n2) {
            if (nums1[p1][0] < nums2[p2][0]) {
                result.push([nums1[p1][0], nums1[p1][1]]);
                p1++;
            } else if (nums2[p2][0] < nums1[p1][0]) {
                result.push([nums2[p2][0], nums2[p2][1]]);
                p2++;
            } else { // ids are equal
                result.push([nums1[p1][0], nums1[p1][1] + nums2[p2][1]]);
                p1++;
                p2++;
            }
        } else if (p1 < n1) {
            result.push([nums1[p1][0], nums1[p1][1]]);
            p1++;
        } else { // p2 < n2
            result.push([nums2[p2][0], nums2[p2][1]]);
            p2++;
        }
    }

    return result;
};